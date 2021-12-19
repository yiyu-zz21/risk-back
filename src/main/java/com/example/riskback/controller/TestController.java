package com.example.riskback.controller;

import com.example.riskback.annotation.LogAnnotation;
import com.example.riskback.utils.InterfaceUtil;
import com.example.riskback.vo.Form;
import com.example.riskback.vo.Pre;
import com.example.riskback.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
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
    public ResultVo<List<String>> postList(@RequestBody Form form){
        BigDecimal bFar = new BigDecimal(form.getFar());
        BigDecimal bCA199 = new BigDecimal(form.getCA199());
        BigDecimal bStaging = new BigDecimal(form.getStaging());
        BigDecimal bTumorDiff = new BigDecimal(form.getTumorDiff());
        BigDecimal y1 = new BigDecimal("14.93247092959410000");
        BigDecimal y2 = new BigDecimal("0.00159237941749691");
        BigDecimal y3 = new BigDecimal("-3.6265079616827800000");
        BigDecimal y = y1.multiply(bFar);
        y = y.add(y2.multiply(bCA199));
        y = y.add(bStaging);
        y = y.add(bTumorDiff);
        y = y.add(y3);
        BigDecimal x = new BigDecimal(Math.pow(Math.E,y.doubleValue()));
        x = x.divide(x.add(new BigDecimal(1)), RoundingMode.HALF_UP).setScale(5,RoundingMode.HALF_UP);
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(3);
        String predicted = percent.format(x.doubleValue());
        String risk = x.doubleValue() > 0.322 ? "High risk" : "Low risk";
        return InterfaceUtil.success(new Pre(predicted,risk));
    }
}
