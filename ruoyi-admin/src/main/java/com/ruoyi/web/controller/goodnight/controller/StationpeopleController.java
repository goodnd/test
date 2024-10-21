package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.Stationpeople;
import com.ruoyi.web.controller.goodnight.service.IStationpeopleService;
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
 * 回收站点人员Controller
 * 
 * @author goodnight
 * @date 2024-10-21
 */
@RestController
@RequestMapping("/system/stationPeople")
public class StationpeopleController extends BaseController
{
    @Autowired
    private IStationpeopleService stationpeopleService;

    /**
     * 查询回收站点人员列表
     */
    @PreAuthorize("@ss.hasPermi('system:stationPeople:list')")
    @GetMapping("/list")
    public TableDataInfo list(Stationpeople stationpeople)
    {
        startPage();
        List<Stationpeople> list = stationpeopleService.selectStationpeopleList(stationpeople);
        return getDataTable(list);
    }

    /**
     * 导出回收站点人员列表
     */
    @PreAuthorize("@ss.hasPermi('system:stationPeople:export')")
    @Log(title = "回收站点人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Stationpeople stationpeople)
    {
        List<Stationpeople> list = stationpeopleService.selectStationpeopleList(stationpeople);
        ExcelUtil<Stationpeople> util = new ExcelUtil<Stationpeople>(Stationpeople.class);
        util.exportExcel(response, list, "回收站点人员数据");
    }

    /**
     * 获取回收站点人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:stationPeople:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stationpeopleService.selectStationpeopleById(id));
    }

    /**
     * 新增回收站点人员
     */
    @PreAuthorize("@ss.hasPermi('system:stationPeople:add')")
    @Log(title = "回收站点人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stationpeople stationpeople)
    {
        return toAjax(stationpeopleService.insertStationpeople(stationpeople));
    }

    /**
     * 修改回收站点人员
     */
    @PreAuthorize("@ss.hasPermi('system:stationPeople:edit')")
    @Log(title = "回收站点人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stationpeople stationpeople)
    {
        return toAjax(stationpeopleService.updateStationpeople(stationpeople));
    }

    /**
     * 删除回收站点人员
     */
    @PreAuthorize("@ss.hasPermi('system:stationPeople:remove')")
    @Log(title = "回收站点人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stationpeopleService.deleteStationpeopleByIds(ids));
    }
}
