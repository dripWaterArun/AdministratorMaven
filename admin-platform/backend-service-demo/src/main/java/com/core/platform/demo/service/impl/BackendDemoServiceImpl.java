package com.core.platform.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.core.platform.demo.mapper.BackendDemoMapper;
import com.core.platform.demo.po.BackendDemo;
import com.core.platform.demo.service.IBackendDemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendDemoServiceImpl extends ServiceImpl<BackendDemoMapper, BackendDemo> implements IBackendDemoService {

    @Override
    public List<BackendDemo> listDemo() {
        return list();
    }
}
