package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.GarbageStation;
import com.ruoyi.web.controller.goodnight.domain.Site;
import com.ruoyi.web.controller.goodnight.service.ISiteService;
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
 * @date 2024-10-18
 */
@RestController
@RequestMapping("/system/site")
public class SiteController extends BaseController
{
    @Autowired
    private ISiteService siteService;

    /**
     * 查询垃圾站点管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:site:list')")
    @PostMapping(value = "listAll")
    public  AjaxResult listAll(){
        List<Site> dataList = siteService.selectSiteList(null);
        return AjaxResult.success(dataList);
    }

    @GetMapping("/list")
    public TableDataInfo list(Site site)
    {
        startPage();
        List<Site> list = siteService.selectSiteList(site);
        return getDataTable(list);
    }

    /**
     * 导出垃圾站点管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:site:export')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Site site)
    {
        List<Site> list = siteService.selectSiteList(site);
        ExcelUtil<Site> util = new ExcelUtil<Site>(Site.class);
        util.exportExcel(response, list, "垃圾站点管理数据");
    }

    /**
     * 获取垃圾站点管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:site:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(siteService.selectSiteById(id));
    }

    /**
     * 新增垃圾站点管理
     */
    @PreAuthorize("@ss.hasPermi('system:site:add')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Site site)
    {
        return toAjax(siteService.insertSite(site));
    }

    /**
     * 修改垃圾站点管理
     */
    @PreAuthorize("@ss.hasPermi('system:site:edit')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Site site)
    {
        return toAjax(siteService.updateSite(site));
    }

    /**
     * 删除垃圾站点管理
     */
    @PreAuthorize("@ss.hasPermi('system:site:remove')")
    @Log(title = "垃圾站点管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(siteService.deleteSiteByIds(ids));
    }
}
