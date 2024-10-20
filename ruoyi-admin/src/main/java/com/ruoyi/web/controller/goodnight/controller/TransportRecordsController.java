package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.TransportRecords;
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

    /**
     * 查询垃圾运输记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:transportRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TransportRecords transportRecords)
    {
        startPage();
        List<TransportRecords> list = transportRecordsService.selectTransportRecordsList(transportRecords);
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
