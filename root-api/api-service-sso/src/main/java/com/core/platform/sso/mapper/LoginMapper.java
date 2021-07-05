package com.core.platform.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.core.platform.sso.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<UserPo> {
}
