package com.core.common.pojo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//import lombok.Data;

/**
 * 返回给前端的共通属性
 * @author daixu
 */
//@Data
public class BaseResult {
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String updateBy;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 删除标记 "0" 展示 "1" 删除
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;}
