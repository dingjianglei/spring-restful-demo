package com.hello.service;

import com.hello.model.User;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 获取所有用户列表
     * @return
     */
    List<User> getAllUser();

    /**
     * 用户登录
     * @param loginName 登录名
     * @param pwd 登录密码
     * @return 验证通过返回User对象 否则 return null
     */
    User login(String loginName,String pwd);

    /**
     * 用户注册
     * @param loginName 登录名
     * @param pwd 登录密码
     * @return 验证通过返回User对象 否则 return null
     */
    User register(String loginName,String pwd);
}
