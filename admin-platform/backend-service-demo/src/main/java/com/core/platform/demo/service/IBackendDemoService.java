package com.core.platform.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.core.platform.demo.po.BackendDemo;

import java.util.List;

public interface IBackendDemoService extends IService<BackendDemo> {

    List<BackendDemo> listDemo();
}
