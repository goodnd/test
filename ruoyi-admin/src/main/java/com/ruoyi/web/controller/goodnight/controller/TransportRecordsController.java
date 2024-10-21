package com.ruoyi.web.controller.goodnight.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.GarbageStation;
import com.ruoyi.web.controller.goodnight.domain.Site;
import com.ruoyi.web.controller.goodnight.domain.TransportRecords;
import com.ruoyi.web.controller.goodnight.mapper.GarbageStationMapper;
import com.ruoyi.web.controller.goodnight.mapper.SiteMapper;
import com.ruoyi.web.controller.goodnight.service.ITransportRecordsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 垃圾运输记录Controller
 * 
 * @author goodnight
 * @date 2024-10-18
 */
@RestController
@RequestMapping("/system/transportRecord")
public class TransportRecordsController extends BaseController
{
    @Autowired
    private ITransportRecordsService transportRecordsService;

    @Autowired
    private SiteMapper siteMapper;

    @Autowired
    private GarbageStationMapper garbageStationMapper;

    /**
     * 查询垃圾运输记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TransportRecords transportRecords)
    {
        startPage();
        List<TransportRecords> list = transportRecordsService.selectTransportRecordsList(transportRecords);
        // 使用 Stream API 提取 transportSites，并转换为 List<Long>
        List<Long> tranSportStationIds = list.stream()
                .map(TransportRecords::getTransportStation) // 获取 transportStation 字符串
                .map(Long::parseLong) // 将字符串转换为 Long
                .collect(Collectors.toList()); // 收集到 List<Long>
        List<Long> transportSiteIds = list.stream()
                .map(TransportRecords::getTransportSites) // 获取每个 TransportRecords 的 transportSites
                .filter(sites -> sites != null && !sites.trim().isEmpty()) // 过滤掉空值
                .flatMap(sites -> {
                    // 按逗号分割并转换为 Long 流
                    String[] sitesArray = sites.split(",");
                    return Arrays.stream(sitesArray) // 将数组转换为流
                            .map(String::trim) // 去除空格
                            .map(site -> {
                                try {
                                    return Long.parseLong(site); // 转换为 Long
                                } catch (NumberFormatException e) {
                                    // 处理转换错误，例如返回 null 或抛出异常
                                    return null; // 返回 null 以便后续过滤
                                }
                            });
                })
                .filter(siteId -> siteId != null) // 过滤掉转换失败的 null
                .distinct() // 可选：去重
                .collect(Collectors.toList());
        //用收集的负责站点id查询后，用map分组快速匹配查询
        if(!transportSiteIds.isEmpty()){
            List<Site> sites = siteMapper.selectSiteListByIds(transportSiteIds);
            List<GarbageStation> stations =new ArrayList<>();
            if(!tranSportStationIds.isEmpty()){
                stations = garbageStationMapper.selectGarbageStationByIds(tranSportStationIds);

            }
            Map<Long, GarbageStation> collect = stations.stream()
                    .collect(Collectors.toMap(GarbageStation::getId, station -> station, (existing, replacement) -> existing));
            Map<Long, Site> collect1 = sites.stream()
                    .collect(Collectors.toMap(Site::getId, site -> site, (existing, replacement) -> existing));
            if(!collect1.isEmpty()){
                for (TransportRecords record : list) {
                    String transportSites = record.getTransportSites();
                    String tranSportStationStr = record.getTransportStation();
                    // 转换为 long 类型
                    Long tranSportStation = Long.parseLong(tranSportStationStr);

                    if (tranSportStation!=null&&!collect.isEmpty()){
                        record.setTransportStationName(collect.get(tranSportStation).getStationName());
                    }
                    if (transportSites != null) {
                        // 将 transportSites 字符串分割为 List<Long>
                        List<Long> idList = Arrays.stream(transportSites.split(","))
                                .map(String::trim) // 去掉前后空格
                                .map(Long::parseLong) // 将 String 转换为 Long
                                .collect(Collectors.toList());

                        // 使用流将 idList 转换为用逗号分隔的 SiteName 字符串
                        String result = idList.stream()
                                .map(collect1::get) // 根据 id 获取 Site 对象
                                .map(Site::getSiteName) // 获取 SiteName
                                .collect(Collectors.joining(",")); // 使用 Collectors.joining() 方法

                        // 设置 transportSitesName
                        record.setTransportSitesName(result);
                    }
                }


            }
        }

        return getDataTable(list);
    }

    /**
     * 导出垃圾运输记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:export')")
    @Log(title = "垃圾运输记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TransportRecords transportRecords)
    {
        List<TransportRecords> list = transportRecordsService.selectTransportRecordsList(transportRecords);
        ExcelUtil<TransportRecords> util = new ExcelUtil<TransportRecords>(TransportRecords.class);
        util.exportExcel(response, list, "垃圾运输记录数据");
    }

    /**
     * 获取垃圾运输记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(transportRecordsService.selectTransportRecordsById(id));
    }

    /**
     * 新增垃圾运输记录
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:add')")
    @Log(title = "垃圾运输记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TransportRecords transportRecords)
    {
        return toAjax(transportRecordsService.insertTransportRecords(transportRecords));
    }

    /**
     * 修改垃圾运输记录
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:edit')")
    @Log(title = "垃圾运输记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TransportRecords transportRecords)
    {
        return toAjax(transportRecordsService.updateTransportRecords(transportRecords));
    }

    /**
     * 删除垃圾运输记录
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:remove')")
    @Log(title = "垃圾运输记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(transportRecordsService.deleteTransportRecordsByIds(ids));
    }
}
