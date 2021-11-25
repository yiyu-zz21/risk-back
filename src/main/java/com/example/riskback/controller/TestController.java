package com.example.riskback.controller;

import com.example.riskback.annotation.LogAnnotation;
import com.example.riskback.utils.InterfaceUtil;
import com.example.riskback.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Api("测试方法")
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "get方法请求")
    @GetMapping("/getList")
    public ResultVo getList(String param){
        return InterfaceUtil.success(param);
    }

    @ApiOperation(value = "post方法请求")
    @PostMapping("/postList")
    @LogAnnotation()
    public ResultVo<List<String>> postList(){
        List<String> list = new ArrayList<>();
        list.add("自治州2");
        list.add("自治州3");
        list.add("自治州4");
        return InterfaceUtil.success(list);
    }
}
