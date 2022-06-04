package com.sang.dynamic_datasource.aspect;

import com.sang.dynamic_datasource.datasource.DataSourceType;
import com.sang.dynamic_datasource.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @ClassName GlobalDataSourceAspect
 * @Description:
 * @Author: Sang
 * @Date: 2022/05/31 22:49 星期二
 * @Version 1.0
 */
@Aspect
@Component
//@Order(10)
public class GlobalDataSourceAspect {

    @Autowired
    HttpSession session;

    @Pointcut("execution(* com.sang.dynamic_datasource.service.*.*(..))")
    public void pc(){
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        DynamicDataSourceContextHolder.setDataSourceType(((String)session.getAttribute(DataSourceType.DS_SESSION_KEY)));
        try {
            return  pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }
}
