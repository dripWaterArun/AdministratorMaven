package com.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${user}")
    private String user;

    @GetMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

    @GetMapping("/get2")
    public String get2() {
        return user;
    }
}
