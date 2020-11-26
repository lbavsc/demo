package io.gy.plat.util;

import lombok.Data;

/**
 * 返回值枚举类
 * @author ${author}
 * @since 2020-11-25
 */
public enum ResultEnum {

    // 找不到网页
    UNKNOWN_ERROR(404, "找不到网页"),
    SUCCESS(200, "成功"),
    USER_NOT_EXIST(1, "用户不存在"),
    USER_IS_EXISTS(2, "用户已存在"),
    DATA_IS_NULL(3, "数据为空"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}