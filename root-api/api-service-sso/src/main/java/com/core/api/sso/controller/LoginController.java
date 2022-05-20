package com.core.api.sso.controller;

//import cn.weiguangfu.swagger2.plus.annotation.ApiPlus;
//import cn.weiguangfu.swagger2.plus.annotation.ApiPlus;
import com.core.api.sso.service.ILoginService;
import com.core.api.sso.po.UserPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单点登录模块
 * @author daixu
 * @date 2021-06-29
 */
@RefreshScope
//@ApiPlus(true)
@RestController
@Api(tags = "单点登录")
@RequestMapping("/api/service/sso")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * 单点登录
     * @return
     * @author daixu
     * @date 2021-06-29
     */
    @GetMapping("/login")
    @ApiOperation(value = "单点登录模块测试",notes="@author daixu  @date 2021-06-29")
    public UserPo loginUser(){
        return loginService.loginUser();
    }
}
