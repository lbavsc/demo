package io.gy.plat.entity;

import lombok.Data;

/**
 * 通用返回数据类
 * @param <T>
 * @author ${author}
 * @since 2020-11-25
 */
@Data
public class ResultEntity<T> {
    private Integer code;
    private String msg;
    private T data;
}
