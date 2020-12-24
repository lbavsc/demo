package io.gy.plat.util;

import lombok.*;

/**
 * 返回值枚举类
 * @author ${author}
 * @since 2020-11-25
 */
@Getter
@ToString
@AllArgsConstructor
public enum ResultCodeEnum {

    // 找不到网页
    UNKNOWN_ERROR("404", "找不到网页"),
    SUCCESS("200", "成功"),
    USER_NOT_EXIST("1", "用户不存在"),
    USER_IS_EXISTS("2", "用户已存在"),
    DATA_IS_NULL("3", "数据为空"),
    ;

    private final String code;
    private final String msg;
}