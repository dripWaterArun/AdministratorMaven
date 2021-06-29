package com.core.platform.sso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RestController
@RequestMapping("/api/service/sso")
@Api(tags = "单点登录")
public class TestController {

    /**
     * 单点登录
     * @return
     * @author daixu
     * @date 2021-06-29
     */
    @GetMapping("/test")
    @ApiOperation(value = "单点登录模块测试",notes="@author daixu  @date 2021-06-29")
    public String listDemo(){
        return "单点登录成功";
    }
}
