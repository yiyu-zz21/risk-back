package com.example.riskback.controller;

import com.example.riskback.utils.InterfaceUtil;
import com.example.riskback.vo.Dcc;
import com.example.riskback.vo.Form;
import com.example.riskback.vo.Pre;
import com.example.riskback.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

@RestController
@CrossOrigin
@Api("dcc请求")
@Log4j2
@RequestMapping("/dcc")
public class DccController {
    private Logger logger = LoggerFactory.getLogger(DccController.class);
    @ApiOperation(value = "dcc方法请求")
    @PostMapping("/post")
    public ResultVo<List<String>> dccList(@RequestBody Dcc dcc){
        logger.info("成功获取到对象：" + dcc.toString());
        BigDecimal bDiameter = new BigDecimal(dcc.getDiameter());
        BigDecimal bCA199 = new BigDecimal(dcc.getCA199());
        BigDecimal bInvasion = new BigDecimal(dcc.getInvasion());
        BigDecimal bTumorDiff = new BigDecimal(dcc.getTumorDiff());
        BigDecimal y1 = new BigDecimal("0.0021779046038327");
        BigDecimal y2 = new BigDecimal("0.350028738551977");
        BigDecimal y3 = new BigDecimal("-3.42480798684834");
        BigDecimal y = y1.multiply(bCA199);
        y = y.add(y2.multiply(bDiameter));
        y = y.add(bInvasion);
        y = y.add(bTumorDiff);
        y = y.add(y3);
        BigDecimal x = new BigDecimal(Math.pow(Math.E,y.doubleValue()));
        x = x.divide(x.add(new BigDecimal(1)), RoundingMode.HALF_UP).setScale(5,RoundingMode.HALF_UP);
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(3);
        String predicted = percent.format(x.doubleValue());
        String risk = x.doubleValue() > 0.365 ? "High risk" : "Low risk";

        logger.info("返回对象: " + predicted + "," + risk);
        return InterfaceUtil.success(new Pre(predicted,risk));
    }
}
