package com.ruoyi.web.controller.goodnight.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.goodnight.domain.UserCredit;
import com.ruoyi.web.controller.goodnight.service.IUserCreditService;
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
 * 用户积分管理Controller
 * 
 * @author goodnight
 * @date 2024-10-06
 */
@RestController
@RequestMapping("/system/credit")
public class UserCreditController extends BaseController
{
    @Autowired
    private IUserCreditService userCreditService;

//    @PostMapping(value = "listAll")
//    public  AjaxResult listAll(){
//        List<UserCredit> dataList = userCreditService.selectUserCreditList(null);
//        return AjaxResult.success(dataList);

    /**
     * 查询用户积分管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:credit:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserCredit userCredit)
    {
        startPage();
        List<UserCredit> list = userCreditService.selectUserCreditList(userCredit);
        return getDataTable(list);
    }

    /**
     * 导出用户积分管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:credit:export')")
    @Log(title = "用户积分管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserCredit userCredit)
    {
        List<UserCredit> list = userCreditService.selectUserCreditList(userCredit);
        ExcelUtil<UserCredit> util = new ExcelUtil<UserCredit>(UserCredit.class);
        util.exportExcel(response, list, "用户积分管理数据");
    }

    /**
     * 获取用户积分管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:credit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userCreditService.selectUserCreditById(id));
    }

    /**
     * 新增用户积分管理
     */
    @PreAuthorize("@ss.hasPermi('system:credit:add')")
    @Log(title = "用户积分管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserCredit userCredit)
    {
        return toAjax(userCreditService.insertUserCredit(userCredit));
    }

    /**
     * 修改用户积分管理
     */
    @PreAuthorize("@ss.hasPermi('system:credit:edit')")
    @Log(title = "用户积分管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserCredit userCredit)
    {
        return toAjax(userCreditService.updateUserCredit(userCredit));
    }

    /**
     * 删除用户积分管理
     */
    @PreAuthorize("@ss.hasPermi('system:credit:remove')")
    @Log(title = "用户积分管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userCreditService.deleteUserCreditByIds(ids));
    }
}
