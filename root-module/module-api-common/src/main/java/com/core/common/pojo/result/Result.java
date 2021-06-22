package com.core.common.pojo.result;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.core.common.enums.StatusCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 自定义响应模型
 * @author daixu
 */
@Data
public class Result<T> implements Serializable {
    /**
     * 定义jackson对象
     */
    //private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 响应业务状态
     */
    @ApiModelProperty(value = "状态代码", required = true)
    private Integer Code;

    /**
     * 响应消息
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 响应中的数据
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * 构造方法
     */
    public Result() {}

    /**
     * 静态方法
     * @param data 数据
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result(data);
    }

    /**
     * 其他消息 比如 用户名称已存在等
     * @param message 消息
     * @param status  状态
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String message, Integer status){
        return new Result(message,status);
    }

    /**
     * 其他消息 比如 用户名称已存在等
     */
    public Result(String message, Integer status) {
        this.Code = status;
        this.message = message;
        this.data = null;
    }

    /**
     * 判断增删改是否成功
     * @param num 受影响的行数
     */
    public Result(Integer num) {
        if (num>0){
            ok();
        }else {
            error();
        }
    }

    /**
     * 执行成功（增删改）
     */
    public void ok() {
        this.Code = StatusCodeEnum.SCUUESS.getValue();
        this.message = StatusCodeEnum.SCUUESS.getDesc();
    }

    /**
     * 执行失败（增删改）
     */
    public void error() {
        this.Code = StatusCodeEnum.FAILED.getValue();
        this.message = StatusCodeEnum.FAILED.getDesc();
    }

    /**
     * 其他对象
     * 判断执行成功 执行失败
     * @param data
     */
    public Result(T data) {
        if (data != null){
            ok(data);
        }else {
            error(data);
        }
    }

    /**
     * 其他对象
     * 设置执行成功状态码
     * @param data
     */
    public void ok(T data) {
        this.Code = StatusCodeEnum.SCUUESS.getValue();
        this.message = StatusCodeEnum.SCUUESS.getDesc();
        this.data = data;
    }

    /**
     * 其他对象
     * 执行失败
     * 设置执行失败状态码
     * @param data
     */
    public void error(T data) {
        this.Code = StatusCodeEnum.FAILED.getValue();
        this.message = StatusCodeEnum.FAILED.getDesc();
        this.data = data;
    }

}
