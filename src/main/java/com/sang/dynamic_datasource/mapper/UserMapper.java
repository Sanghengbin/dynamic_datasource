package com.sang.dynamic_datasource.mapper;

import com.sang.dynamic_datasource.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description:
 * @Author: Sang
 * @Date: 2022/05/30 21:54 星期一
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUsers();
}
