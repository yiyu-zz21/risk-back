package com.example.riskback.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Aspect
@Component
@Slf4j
public class LogAspect {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 设置操作日志切入点，在注解的位置切入
     */
    @Pointcut("@annotation(com.example.riskback.annotation.LogAnnotation)")
    public void operLogPointCut(){

    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Exception
     */
    @Around(value = "operLogPointCut()")
    public Object coreServiceMonitor(ProceedingJoinPoint pjp) throws Exception {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        String methodname = signature.getDeclaringType().getSimpleName() + "#" + signature.getMethod().getName();

        Object[] args = pjp.getArgs();
        Object result = null;
        try{
            log.info("前置操作");
            result = pjp.proceed();
            log.info("后置操作");
            return result;
        }catch (Throwable e){
            log.error("异常通知");
            throw new Exception(e.getMessage());
        }finally {

        }
    }
}
