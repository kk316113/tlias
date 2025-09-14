package com.gsh.aop;

import com.gsh.mapper.OperateLogMapper;
import com.gsh.pojo.OperateLog;
import com.gsh.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.gsh.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - begin;
        //构建日志对象
        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getCurrentEmpId());
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(joinPoint.getTarget().getClass().getName());
        olog.setMethodName(joinPoint.getSignature().getName());
        olog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        olog.setReturnValue(result!=null?result.toString():"void");
        olog.setCostTime(costTime);
        log.info("操作日志:{}", olog);
        operateLogMapper.insert(olog);
        return result;
    }

    private Integer getCurrentEmpId() {
        //获取当前操作用户
        return CurrentHolder.getCurrentId();
    }
}
