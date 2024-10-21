package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.Driver;
import com.ruoyi.web.controller.goodnight.service.IDriverService;
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
 * 运输人员管理Controller
 * 
 * @author goodnight
 * @date 2024-10-22
 */
@RestController
@RequestMapping("/system/driver")
public class DriverController extends BaseController
{
    @Autowired
    private IDriverService driverService;

    /**
     * 查询运输人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:driver:list')")
    @GetMapping("/list")
    public TableDataInfo list(Driver driver)
    {
        startPage();
        List<Driver> list = driverService.selectDriverList(driver);
        return getDataTable(list);
    }

    /**
     * 导出运输人员管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:driver:export')")
    @Log(title = "运输人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Driver driver)
    {
        List<Driver> list = driverService.selectDriverList(driver);
        ExcelUtil<Driver> util = new ExcelUtil<Driver>(Driver.class);
        util.exportExcel(response, list, "运输人员管理数据");
    }

    /**
     * 获取运输人员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:driver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(driverService.selectDriverById(id));
    }

    /**
     * 新增运输人员管理
     */
    @PreAuthorize("@ss.hasPermi('system:driver:add')")
    @Log(title = "运输人员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Driver driver)
    {
        return toAjax(driverService.insertDriver(driver));
    }

    /**
     * 修改运输人员管理
     */
    @PreAuthorize("@ss.hasPermi('system:driver:edit')")
    @Log(title = "运输人员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Driver driver)
    {
        return toAjax(driverService.updateDriver(driver));
    }

    /**
     * 删除运输人员管理
     */
    @PreAuthorize("@ss.hasPermi('system:driver:remove')")
    @Log(title = "运输人员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(driverService.deleteDriverByIds(ids));
    }
}
