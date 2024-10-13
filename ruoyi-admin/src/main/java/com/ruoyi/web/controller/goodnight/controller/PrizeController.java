package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.Prize;
import com.ruoyi.web.controller.goodnight.service.IPrizeService;
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
 * 奖品管理Controller
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@RestController
@RequestMapping("/system/prize")
public class PrizeController extends BaseController
{
    @Autowired
    private IPrizeService prizeService;
//    获取所有分类信息
    @PostMapping(value = "listAll")
    public  AjaxResult listAll(){
        List<Prize> dataList = prizeService.selectPrizeList(null);
        return AjaxResult.success(dataList);
    }

    /**
     * 查询奖品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:prize:list')")
    @GetMapping("/list")
    public TableDataInfo list(Prize prize)
    {
        startPage();
        List<Prize> list = prizeService.selectPrizeList(prize);
        return getDataTable(list);
    }

    /**
     * 导出奖品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:prize:export')")
    @Log(title = "奖品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Prize prize)
    {
        List<Prize> list = prizeService.selectPrizeList(prize);
        ExcelUtil<Prize> util = new ExcelUtil<Prize>(Prize.class);
        util.exportExcel(response, list, "奖品管理数据");
    }

    /**
     * 获取奖品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:prize:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(prizeService.selectPrizeById(id));
    }

    /**
     * 新增奖品管理
     */
    @PreAuthorize("@ss.hasPermi('system:prize:add')")
    @Log(title = "奖品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Prize prize)
    {
        return toAjax(prizeService.insertPrize(prize));
    }

    /**
     * 修改奖品管理
     */
    @PreAuthorize("@ss.hasPermi('system:prize:edit')")
    @Log(title = "奖品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Prize prize)
    {
        return toAjax(prizeService.updatePrize(prize));
    }

    /**
     * 删除奖品管理
     */
    @PreAuthorize("@ss.hasPermi('system:prize:remove')")
    @Log(title = "奖品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(prizeService.deletePrizeByIds(ids));
    }
}
