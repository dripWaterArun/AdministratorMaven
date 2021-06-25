package com.core.api.common.entity.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页数据(前台接收参数)
 * @author daixu
 * @author 2016-6-23
 */
@Data
@ApiModel(value="分页bean类",description="分页查询接收参数")
public class PageQueryDto
{
    /** 当前记录起始索引 最小为1 */
    @Min(value=1)
    @NotNull(message = "当前页数不能为空")
    @ApiModelProperty(value = "当前页数（必传）",required=true,example="1")
    private Integer pageNum;

    /** 每页显示记录数 最小为1*/
    @Min(value=1)
    @NotNull(message = "每页显示条数不能为空")
    @ApiModelProperty(value = "每页显示多少条（必传）",required=true,example="2")
    private Integer pageSize;

}
