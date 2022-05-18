package com.core.platform.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/nacos")
@Api(tags = "案例模板:测试表（mybatis-plus 方式）")
public class NacosController {

//    @Value("${your.configuration}")
//    private String useLocalCache;
//
    @Value("${knife4j.basic.username}")
    private String yours;
//
//    @Value("${config}")
//    private String config;
//
//    @GetMapping("/get")
//    public String get() {
//        return useLocalCache;
//    }
//
    @GetMapping("/get2")
    @ApiOperation(value = "测试配置文件",notes="@author daixu @date 2021-06-28")
    public String get2() {
        return yours;
    }
//
//    @GetMapping("/get3")
//    public String get3() {
//        return config;
//    }
}
