package com.core.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否已读
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultCode {
    FAILED(-1,"执行失败"),
    SCUUESS(0, "执行成功"),
    ERROR_PARAM(-2,"参数异常"),
    ERROR_OTHER(-3,"其他异常"),
    ERROR_DB_EXCEPTION(-4,"数据库异常");

    ResultCode(int code, String display) {
        this.code = code;
        this.display = display;
    }

    private int code;
    private String display;


    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    private static final Map<Integer, ResultCode> codeToEnum = new HashMap<Integer, ResultCode>();

    public static final Map<Integer, String> enumMap = new HashMap<Integer, String>();


    static {
        for (ResultCode myenum : values()) {
            codeToEnum.put(myenum.getCode(), myenum);
            enumMap.put(myenum.getCode(), myenum.getDisplay());
        }
    }

    public static ResultCode valueOf(Integer s) {
        return codeToEnum.get(s);
    }
}
