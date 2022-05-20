package com.core.api.sso.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.core.api.common.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表实体类
 * @author daixu
 * @date 2022-04-28 19:29
 */
@Data
@TableName(value = "u_user")
@EqualsAndHashCode(callSuper = true)
public class UserPo extends BaseEntity<UserPo> {

    /**
     * 主键 id
     */
    @TableId(value = "pk_id")
    private Long pkId;

    /**
     * 用户名
     */
    @TableField(value = "username",exist = true)
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password",exist = true)
    private String password;

    /**
     * 手机号
     */
    @TableField(value = "phone_number",exist = true)
    private String phoneNumber;
}
