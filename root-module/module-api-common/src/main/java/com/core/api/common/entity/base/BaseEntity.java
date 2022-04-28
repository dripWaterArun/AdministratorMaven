package com.core.api.common.entity.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * pojo 公共属性父类（mybatis-plus自动填充用）
 * @param <T> 实体类泛型
 * @author daixu
 * @date 2022-04-28 11:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntity<T extends Model> extends Model {

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField(value = "create_by",fill = FieldFill.INSERT,exist = true)
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "gmt_create",fill = FieldFill.INSERT,exist = true)
    private LocalDateTime gmtCreate;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    @TableField(value = "modified_by",fill = FieldFill.INSERT_UPDATE)
    private String modifiedBy;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE,exist = true)
    private LocalDateTime gmtModified;

    /**
     * 逻辑删除标识（1 表示删除，0 表示未删除）
     * 配置注解 @TableLogic(value = "0",delval = "1") 为逻辑删除
     * 不配置注解为物理删除
     */
    @ApiModelProperty(value = "删除标记")
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "is_delete",fill = FieldFill.INSERT ,condition = "0",select = true,exist = true)
    private int deleteFlag;

}

