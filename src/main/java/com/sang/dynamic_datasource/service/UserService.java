package com.sang.dynamic_datasource.service;

import com.sang.dynamic_datasource.annotation.DataSource;
import com.sang.dynamic_datasource.mapper.UserMapper;
import com.sang.dynamic_datasource.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description:
 * @Author: Sang
 * @Date: 2022/05/30 21:55 星期一
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

//    @DataSource("slave")
    public List<User> getAllUsers(){
       return userMapper.getAllUsers();
    }
}
