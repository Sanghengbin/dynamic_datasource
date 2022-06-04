package com.sang.dynamic_datasource.annotation;

import com.sang.dynamic_datasource.datasource.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注解加在某个service类或方法上，通过value属性来指定类或方法使用那个数据源
 * @author Sang
 * @date 2022/5/29/0029 13:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DataSource {
    // 如果一个方法加了@DateSource加了注解，但没有指定数据源名称，则使用默认数据源
    String value() default DataSourceType.DEFAULT_DS_NAME;
}
