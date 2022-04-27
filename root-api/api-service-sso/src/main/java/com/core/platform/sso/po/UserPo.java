package com.core.platform.sso.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "u_user")
public class UserPo {

    /**
     * 主键 id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 逻辑删除标识（1 表示删除，0 表示未删除）
     */
    @TableField(value = "is_delete",exist = true)
    private int deleteFlag;
}
