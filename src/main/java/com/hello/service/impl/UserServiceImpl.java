package com.hello.service.impl;

import com.hello.exception.BusinessException;
import com.hello.model.User;
import com.hello.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务实现
 */
@Service
public class UserServiceImpl  implements UserService{
    @Override
    public List<User> getAllUser() {
        List<User>  resList=new ArrayList<User>();
        for(int i=0;i<3;i++){
            resList.add(new User("Lei",10+i,"ShangHai"));
        }
        return resList;
    }
    @Override
    public User login(String loginName,String pwd){
        if(StringUtils.isEmpty(loginName)||StringUtils.isEmpty(pwd)){
            throw new RuntimeException("参数缺失");
        }
        if("jianglei".equals(loginName)&&"123".equals(pwd)){
            User loginUser= new User();
            loginUser.setName(loginName);
            loginUser.setAge(26);
            loginUser.setAddress("ShangHai JiaDing");
            return loginUser;
        }
        return null;
    }

    @Override
    public User register(String loginName,String pwd){
        if(StringUtils.isEmpty(loginName)||StringUtils.isEmpty(pwd)){
            throw new RuntimeException("参数缺失");
        }
        if("jianglei".equals(loginName)){
            throw new BusinessException("用户名已被占用");
        }
        //执行注册操作 TODO
        User registerUser= new User();
        registerUser.setName(loginName);
        registerUser.setAge(26);
        registerUser.setAddress("ShangHai JiaDing");
        return registerUser;
    }
}
