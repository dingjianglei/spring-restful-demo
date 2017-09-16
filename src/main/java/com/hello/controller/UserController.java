package com.hello.controller;

import com.hello.common.ResultResponse;
import com.hello.model.User;
import com.hello.params.LoginParam;
import com.hello.params.RegisterParam;
import com.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger LOG= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 获取用户列表服务
     * @return ResultResponse if success=true 服务处理成功 is success=false 服务处理失败
     */
    @RequestMapping(value = "/all",method={RequestMethod.GET,RequestMethod.POST})
    public ResultResponse getAllUser(){
        try {
            List<User> resList= userService.getAllUser();
            return new ResultResponse().success("success").data(resList);//构造成功返回结果
        }catch (Exception e){
            LOG.error("getAllUser errorMsg:{}",e.getMessage());
            return new ResultResponse().fail("查询失败");//构造异常返回结果
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultResponse login(@RequestBody @Valid LoginParam loginParam){
        try{
            User loginUser=userService.login(loginParam.getLoginName(),loginParam.getPassword());
            if(loginUser!=null){
                return  new ResultResponse().success("success").data(loginUser);
            }else{
                return new ResultResponse().fail("用户名或密码错误");
            }
        }catch (Exception e){
            return new ResultResponse().fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultResponse register(@RequestBody @Valid RegisterParam registerParam){
        User registerUser=userService.register(registerParam.getLoginName(),registerParam.getPassword());
        if(registerUser!=null){
            return  new ResultResponse().success("success").data(registerUser);
        }else{
            return new ResultResponse().fail("注册失败");
        }
    }
}
