package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.GarbageCollectionRecords;
import com.ruoyi.web.controller.goodnight.service.IGarbageCollectionRecordsService;
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
 * 垃圾收集记录管理Controller
 * 
 * @author goodnight
 * @date 2024-10-17
 */
@RestController
@RequestMapping("/system/records")
public class GarbageCollectionRecordsController extends BaseController
{
    @Autowired
    private IGarbageCollectionRecordsService garbageCollectionRecordsService;

    /**
     * 查询垃圾收集记录管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(GarbageCollectionRecords garbageCollectionRecords)
    {
        startPage();
        List<GarbageCollectionRecords> list = garbageCollectionRecordsService.selectGarbageCollectionRecordsList(garbageCollectionRecords);
        return getDataTable(list);
    }

    /**
     * 导出垃圾收集记录管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:records:export')")
    @Log(title = "垃圾收集记录管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GarbageCollectionRecords garbageCollectionRecords)
    {
        List<GarbageCollectionRecords> list = garbageCollectionRecordsService.selectGarbageCollectionRecordsList(garbageCollectionRecords);
        ExcelUtil<GarbageCollectionRecords> util = new ExcelUtil<GarbageCollectionRecords>(GarbageCollectionRecords.class);
        util.exportExcel(response, list, "垃圾收集记录管理数据");
    }

    /**
     * 获取垃圾收集记录管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:records:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(garbageCollectionRecordsService.selectGarbageCollectionRecordsById(id));
    }

    /**
     * 新增垃圾收集记录管理
     */
    @PreAuthorize("@ss.hasPermi('system:records:add')")
    @Log(title = "垃圾收集记录管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GarbageCollectionRecords garbageCollectionRecords)
    {
        return toAjax(garbageCollectionRecordsService.insertGarbageCollectionRecords(garbageCollectionRecords));
    }

    /**
     * 修改垃圾收集记录管理
     */
    @PreAuthorize("@ss.hasPermi('system:records:edit')")
    @Log(title = "垃圾收集记录管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GarbageCollectionRecords garbageCollectionRecords)
    {
        return toAjax(garbageCollectionRecordsService.updateGarbageCollectionRecords(garbageCollectionRecords));
    }

    /**
     * 删除垃圾收集记录管理
     */
    @PreAuthorize("@ss.hasPermi('system:records:remove')")
    @Log(title = "垃圾收集记录管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(garbageCollectionRecordsService.deleteGarbageCollectionRecordsByIds(ids));
    }
}
