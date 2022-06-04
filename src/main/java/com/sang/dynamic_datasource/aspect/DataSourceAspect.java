package com.sang.dynamic_datasource.aspect;

import com.sang.dynamic_datasource.annotation.DataSource;
import com.sang.dynamic_datasource.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName DataSourceAspect
 * @Description:
 * @Author: Sang
 * @Date: 2022/05/29 13:28 星期日
 * @Version 1.0
 */
@Component
@Aspect
//@Order(11)
public class DataSourceAspect {

    /**
     * 定义切点
     *
     * @annotation(com.sang.dynamic_datasource.annotation.DataSource)表示方法上有@DataSource注解就将方法拦截下来
     * @within(com.sang.dynamic_datasource.annotation.DataSource) 表示类上有@DataSource注解就将类方法拦截下来
     */
    @Pointcut("@annotation(com.sang.dynamic_datasource.annotation.DataSource) || @within(com.sang.dynamic_datasource.annotation.DataSource)")
    public void pc() {

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        //获取方法上面的有效注解
        DataSource dataSource = getDataSource(pjp);
        if (dataSource != null){
            // value就是数据源的名称
            String value = dataSource.value();
            DynamicDataSourceContextHolder.setDataSourceType(value);
        }
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            //最终清除掉
            DynamicDataSourceContextHolder.clearDataSourceType();;
        }
        return null;
    }

    private DataSource getDataSource(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        //查找方法里的DataSource注解
        DataSource annotation = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (annotation != null){
            //说明方法上有DataSource注解
            return annotation;
        }
        //去类上找DataSource注解
        return AnnotationUtils.findAnnotation(signature.getMethod(),DataSource.class);
    }

}
