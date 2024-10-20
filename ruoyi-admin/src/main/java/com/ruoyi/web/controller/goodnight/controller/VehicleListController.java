package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.VehicleList;
import com.ruoyi.web.controller.goodnight.service.IVehicleListService;
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
 * 运输车辆Controller
 * 
 * @author goodnight
 * @date 2024-10-18
 */
@RestController
@RequestMapping("/system/list")
public class VehicleListController extends BaseController
{
    @Autowired
    private IVehicleListService vehicleListService;

    /**
     * 查询运输车辆列表
     */
    @PreAuthorize("@ss.hasPermi('system:list:list')")
    @GetMapping("/list")
    public TableDataInfo list(VehicleList vehicleList)
    {
        startPage();
        List<VehicleList> list = vehicleListService.selectVehicleListList(vehicleList);
        return getDataTable(list);
    }

    /**
     * 导出运输车辆列表
     */
    @PreAuthorize("@ss.hasPermi('system:list:export')")
    @Log(title = "运输车辆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VehicleList vehicleList)
    {
        List<VehicleList> list = vehicleListService.selectVehicleListList(vehicleList);
        ExcelUtil<VehicleList> util = new ExcelUtil<VehicleList>(VehicleList.class);
        util.exportExcel(response, list, "运输车辆数据");
    }

    /**
     * 获取运输车辆详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:list:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vehicleListService.selectVehicleListById(id));
    }

    /**
     * 新增运输车辆
     */
    @PreAuthorize("@ss.hasPermi('system:list:add')")
    @Log(title = "运输车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VehicleList vehicleList)
    {
        return toAjax(vehicleListService.insertVehicleList(vehicleList));
    }

    /**
     * 修改运输车辆
     */
    @PreAuthorize("@ss.hasPermi('system:list:edit')")
    @Log(title = "运输车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VehicleList vehicleList)
    {
        return toAjax(vehicleListService.updateVehicleList(vehicleList));
    }

    /**
     * 删除运输车辆
     */
    @PreAuthorize("@ss.hasPermi('system:list:remove')")
    @Log(title = "运输车辆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vehicleListService.deleteVehicleListByIds(ids));
    }
}
