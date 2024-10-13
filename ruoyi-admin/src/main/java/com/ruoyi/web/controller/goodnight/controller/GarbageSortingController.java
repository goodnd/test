package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.GarbageSorting;
import com.ruoyi.web.controller.goodnight.service.IGarbageSortingService;
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
 * 垃圾分类管理Controller
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@RestController
@RequestMapping("/system/sorting")
public class GarbageSortingController extends BaseController
{
    @Autowired
    private IGarbageSortingService garbageSortingService;

    /**
     * 查询垃圾分类管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sorting:list')")
    @GetMapping("/list")
    public TableDataInfo list(GarbageSorting garbageSorting)
    {
        startPage();
        List<GarbageSorting> list = garbageSortingService.selectGarbageSortingList(garbageSorting);
        return getDataTable(list);
    }

    /**
     * 导出垃圾分类管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sorting:export')")
    @Log(title = "垃圾分类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GarbageSorting garbageSorting)
    {
        List<GarbageSorting> list = garbageSortingService.selectGarbageSortingList(garbageSorting);
        ExcelUtil<GarbageSorting> util = new ExcelUtil<GarbageSorting>(GarbageSorting.class);
        util.exportExcel(response, list, "垃圾分类管理数据");
    }

    /**
     * 获取垃圾分类管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sorting:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(garbageSortingService.selectGarbageSortingById(id));
    }

    /**
     * 新增垃圾分类管理
     */
    @PreAuthorize("@ss.hasPermi('system:sorting:add')")
    @Log(title = "垃圾分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GarbageSorting garbageSorting)
    {
        return toAjax(garbageSortingService.insertGarbageSorting(garbageSorting));
    }

    /**
     * 修改垃圾分类管理
     */
    @PreAuthorize("@ss.hasPermi('system:sorting:edit')")
    @Log(title = "垃圾分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GarbageSorting garbageSorting)
    {
        return toAjax(garbageSortingService.updateGarbageSorting(garbageSorting));
    }

    /**
     * 删除垃圾分类管理
     */
    @PreAuthorize("@ss.hasPermi('system:sorting:remove')")
    @Log(title = "垃圾分类管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(garbageSortingService.deleteGarbageSortingByIds(ids));
    }
}
