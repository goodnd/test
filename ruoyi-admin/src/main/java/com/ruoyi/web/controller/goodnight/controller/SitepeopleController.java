package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.Sitepeople;
import com.ruoyi.web.controller.goodnight.service.ISitepeopleService;
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
 * 垃圾站点人员Controller
 * 
 * @author goodnight
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/system/sitePeople")
public class SitepeopleController extends BaseController
{
    @Autowired
    private ISitepeopleService sitepeopleService;

    /**
     * 查询垃圾站点人员列表
     */
    @PreAuthorize("@ss.hasPermi('system:sitePeople:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sitepeople sitepeople)
    {
        startPage();
        List<Sitepeople> list = sitepeopleService.selectSitepeopleList(sitepeople);
        return getDataTable(list);
    }

    /**
     * 导出垃圾站点人员列表
     */
    @PreAuthorize("@ss.hasPermi('system:sitePeople:export')")
    @Log(title = "垃圾站点人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sitepeople sitepeople)
    {
        List<Sitepeople> list = sitepeopleService.selectSitepeopleList(sitepeople);
        ExcelUtil<Sitepeople> util = new ExcelUtil<Sitepeople>(Sitepeople.class);
        util.exportExcel(response, list, "垃圾站点人员数据");
    }

    /**
     * 获取垃圾站点人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sitePeople:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sitepeopleService.selectSitepeopleById(id));
    }

    /**
     * 新增垃圾站点人员
     */
    @PreAuthorize("@ss.hasPermi('system:sitePeople:add')")
    @Log(title = "垃圾站点人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sitepeople sitepeople)
    {
        return toAjax(sitepeopleService.insertSitepeople(sitepeople));
    }

    /**
     * 修改垃圾站点人员
     */
    @PreAuthorize("@ss.hasPermi('system:sitePeople:edit')")
    @Log(title = "垃圾站点人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sitepeople sitepeople)
    {
        return toAjax(sitepeopleService.updateSitepeople(sitepeople));
    }

    /**
     * 删除垃圾站点人员
     */
    @PreAuthorize("@ss.hasPermi('system:sitePeople:remove')")
    @Log(title = "垃圾站点人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sitepeopleService.deleteSitepeopleByIds(ids));
    }
}
