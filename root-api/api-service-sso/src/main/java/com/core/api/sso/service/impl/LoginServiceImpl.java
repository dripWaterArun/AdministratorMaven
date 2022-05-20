package com.core.api.sso.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.core.api.sso.service.ILoginService;
import com.core.api.sso.mapper.LoginMapper;
import com.core.api.sso.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, UserPo> implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserPo loginUser() {
        return getById(1L);
    }
}
