package com.core.platform.sso.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.core.platform.sso.po.UserPo;

public interface ILoginService extends IService<UserPo> {

    UserPo loginUser();
}
