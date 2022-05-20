package com.core.api.sso.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.core.api.sso.po.UserPo;

public interface ILoginService extends IService<UserPo> {

    UserPo loginUser();
}
