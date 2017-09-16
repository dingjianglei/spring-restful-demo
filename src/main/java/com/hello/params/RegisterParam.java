package com.hello.params;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户注册参数类
 */
public class RegisterParam {
    @NotEmpty(message = "用户登录名不能为空")
    private String loginName;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
