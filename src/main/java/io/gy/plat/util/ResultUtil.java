package io.gy.plat.util;

import io.gy.plat.entity.ResultEntity;

public class ResultUtil {

    /**
     * 成功且带数据
     **/
    public static ResultEntity success(Object object) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(ResultEnum.SUCCESS.getCode());
        resultEntity.setMsg(ResultEnum.SUCCESS.getMsg());
        resultEntity.setData(object);
        return resultEntity;
    }

    /**
     * 成功但不带数据
     **/
    public static ResultEntity success() {

        return success(null);
    }

    /**
     * 失败
     **/
    public static ResultEntity error(Integer code, String msg) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(code);
        resultEntity.setMsg(msg);
        return resultEntity;
    }

}
