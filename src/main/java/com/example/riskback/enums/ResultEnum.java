package com.example.riskback.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public enum ResultEnum {
    SUCCESS(1,"成功"),
    FAIL(0,"失败"),
    SERVICE_ERROR(2,"服务错误");

    private Integer code;
    private String info;

    public Integer getCode(){
        return this.code;
    }
    public String getInfo(){
        return this.info;
    }
}
