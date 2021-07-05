package com.core.platform.sso.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserPo {

    private Long id;

    private String username;

    private String password;

    private String phone;

    @TableField(value = "is_deleted",exist = true)
    private String deleted;
}
