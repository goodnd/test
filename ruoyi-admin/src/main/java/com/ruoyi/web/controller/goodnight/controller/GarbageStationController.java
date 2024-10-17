package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.GarbageStation;
import com.ruoyi.web.controller.goodnight.domain.Prize;
import com.ruoyi.web.controller.goodnight.service.IGarbageStationService;
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
 * 垃圾回收站管理Controller
 * 
 * @author goodnight
 * @date 2024-10-04
 */
@RestController
@RequestMapping("/system/station")
public class GarbageStationController extends BaseController
{
    @Autowired
    private IGarbageStationService garbageStationService;
    // 获取所有垃圾回收站点信息
    @PostMapping(value = "listAll")
    public  AjaxResult listAll(){
        List<GarbageStation> dataList = garbageStationService.selectGarbageStationList(null);
        return AjaxResult.success(dataList);
    }

    /**
     * 查询垃圾回收站管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:station:list')")
    @GetMapping("/list")
    public TableDataInfo list(GarbageStation garbageStation)
    {
        startPage();
        List<GarbageStation> list = garbageStationService.selectGarbageStationList(garbageStation);
        return getDataTable(list);
    }

    /**
     * 导出垃圾回收站管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:station:export')")
    @Log(title = "垃圾回收站管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GarbageStation garbageStation)
    {
        List<GarbageStation> list = garbageStationService.selectGarbageStationList(garbageStation);
        ExcelUtil<GarbageStation> util = new ExcelUtil<GarbageStation>(GarbageStation.class);
        util.exportExcel(response, list, "垃圾回收站管理数据");
    }

    /**
     * 获取垃圾回收站管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:station:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(garbageStationService.selectGarbageStationById(id));
    }

    /**
     * 新增垃圾回收站管理
     */
    @PreAuthorize("@ss.hasPermi('system:station:add')")
    @Log(title = "垃圾回收站管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GarbageStation garbageStation)
    {
        return toAjax(garbageStationService.insertGarbageStation(garbageStation));
    }

    /**
     * 修改垃圾回收站管理
     */
    @PreAuthorize("@ss.hasPermi('system:station:edit')")
    @Log(title = "垃圾回收站管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GarbageStation garbageStation)
    {
        return toAjax(garbageStationService.updateGarbageStation(garbageStation));
    }

    /**
     * 删除垃圾回收站管理
     */
    @PreAuthorize("@ss.hasPermi('system:station:remove')")
    @Log(title = "垃圾回收站管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(garbageStationService.deleteGarbageStationByIds(ids));
    }
}
