package com.example.riskback.utils;

import com.example.riskback.enums.ResultEnum;
import com.example.riskback.vo.ResultVo;

public class InterfaceUtil {
    public static ResultVo success() {
        return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getInfo(), null);
    }

    public static ResultVo success(Object data) {
        return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getInfo(), data);
    }

    public static ResultVo error(String info) {
        return new ResultVo(ResultEnum.SERVICE_ERROR.getCode(), info, null);
    }

    public static ResultVo error(ResultEnum resultEnum) {
        return new ResultVo(resultEnum.getCode(), resultEnum.getInfo(), null);
    }

    public static ResultVo error(ResultEnum resultEnum, String info) {
        return new ResultVo(resultEnum.getCode(), info, null);
    }

    public static ResultVo error(Integer code, String info) {
        return new ResultVo(code, info, null);
    }
}
