package com.core.common.pojo.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * pojo公共属性父类（mybatis-plus自动填充用）
 * @param <T> 实体类泛型
 * @author daixu
 */
@Data
public abstract class BaseEntity<T extends Model> extends Model {

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField(value = "createBy",fill = FieldFill.INSERT,exist = true)
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "createTime",fill = FieldFill.INSERT,exist = true)
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    @TableField(value = "updateBy",fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE,exist = true)
    private LocalDateTime updateTime;

    /**
     * 删除标记 "0" 展示 "1" 删除
     * 配置注解 @TableLogic(value = "0",delval = "1") 为逻辑删除
     * 不配置注解为物理删除
     */
    @ApiModelProperty(value = "删除标记")
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "delFlag",fill = FieldFill.INSERT ,condition = "0",select = true,exist = true)
    private String delFlag;

}

