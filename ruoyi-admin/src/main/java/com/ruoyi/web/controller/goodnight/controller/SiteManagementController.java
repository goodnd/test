package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.SiteManagement;
import com.ruoyi.web.controller.goodnight.service.ISiteManagementService;
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
 * 垃圾站点管理Controller
 * 
 * @author goodnight
 * @date 2024-10-04
 */
@RestController
@RequestMapping("/system/site")
public class SiteManagementController extends BaseController
{
    @Autowired
    private ISiteManagementService siteManagementService;

    /**
     * 查询垃圾站点管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:site:list')")
    @GetMapping("/list")
    public TableDataInfo list(SiteManagement siteManagement)
    {
        startPage();
        List<SiteManagement> list = siteManagementService.selectSiteManagementList(siteManagement);
        return getDataTable(list);
    }

    /**
     * 导出垃圾站点管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:site:export')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SiteManagement siteManagement)
    {
        List<SiteManagement> list = siteManagementService.selectSiteManagementList(siteManagement);
        ExcelUtil<SiteManagement> util = new ExcelUtil<SiteManagement>(SiteManagement.class);
        util.exportExcel(response, list, "垃圾站点管理数据");
    }

    /**
     * 获取垃圾站点管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:site:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(siteManagementService.selectSiteManagementById(id));
    }

    /**
     * 新增垃圾站点管理
     */
    @PreAuthorize("@ss.hasPermi('system:site:add')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SiteManagement siteManagement)
    {
        return toAjax(siteManagementService.insertSiteManagement(siteManagement));
    }

    /**
     * 修改垃圾站点管理
     */
    @PreAuthorize("@ss.hasPermi('system:site:edit')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SiteManagement siteManagement)
    {
        return toAjax(siteManagementService.updateSiteManagement(siteManagement));
    }

    /**
     * 删除垃圾站点管理
     */
    @PreAuthorize("@ss.hasPermi('system:site:remove')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(siteManagementService.deleteSiteManagementByIds(ids));
    }
}
