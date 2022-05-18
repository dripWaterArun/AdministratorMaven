package com.core.platform.demo.controller;

import com.core.platform.demo.po.BackendDemo;
import com.core.platform.demo.service.IBackendDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后端：案例展示模块 controller 层
 * @author daixu
 * @date 2021-06-28
 */
@RefreshScope
@RestController
@RequestMapping("/backend/service/demo")
@Api(tags = "案例模板:测试表（mybatis-plus 方式）")
public class BackendDemoController {

    @Autowired
    private IBackendDemoService backendDemoService;

    /**
     * 查询测试详情（分页查询）
     * @return 案例数据列表
     * @author daixu
     * @date 2021-06-28
     */
//    @GetMapping("/demo")
//    @ApiOperation(value = "查询测试详情（分页查询）",notes="@author daixu @date 2021-06-28")
//    public List<BackendDemo> listDemo(){
//        return backendDemoService.listDemo();
//    }

}
