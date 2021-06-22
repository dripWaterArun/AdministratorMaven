package com.core.common.enums;

/**
 * 枚举类 返回结果
 * @author daixu
 */
public enum StatusCodeEnum {
    FAILED(500, "执行失败"),
    SCUUESS(200, "执行成功"),
    ERROR_OTHER(-1,"其他异常"),
    NOT_DATA(-2,"该数据不存在"),
    REPEAT_NAME(-3,"名称已存在"),
    PARAMETER_ERROR(-4,"参数错误"),
    ID_REPEAT(-5,"身份证号格式不对"),
    PHONE_REPEAT(-6,"手机号格式不对"),
    ERROR_DB_EXCEPTION(-7,"数据库异常"),
    DATE_FORMAT_ERROR(-8,"日期格式错误"),
    ID_NUMBER_REPEAT(-9,"身份证号已存在"),
    PHONE_NUMBER_REPEAT(-10,"手机号已存在");


    private Integer value;
    private String desc;

    StatusCodeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
