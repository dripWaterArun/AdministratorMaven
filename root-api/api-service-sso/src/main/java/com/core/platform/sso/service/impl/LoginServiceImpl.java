package com.core.platform.sso.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.core.platform.sso.mapper.LoginMapper;
import com.core.platform.sso.po.UserPo;
import com.core.platform.sso.service.ILoginService;
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
