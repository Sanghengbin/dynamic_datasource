package com.sang.dynamic_datasource.controller;

import com.sang.dynamic_datasource.datasource.DataSourceType;

import com.sang.dynamic_datasource.model.User;
import com.sang.dynamic_datasource.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName DataSourceController
 * @Description:
 * @Author: Sang
 * @Date: 2022/05/31 22:42 星期二
 * @Version 1.0
 */
@RestController
public class DataSourceController {

    private static  final Logger logger = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    UserService userService;

    /***
     * 修改数据源
     */
    @PostMapping("/dstype")
    public void setDsType(String dsType, HttpSession session){
        session.setAttribute(DataSourceType.DS_SESSION_KEY,dsType);
        logger.info("数据源切换为 {}",dsType);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
