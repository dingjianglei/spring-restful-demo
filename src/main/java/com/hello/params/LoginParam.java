package com.hello.params;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 用户登录参数实体类
 */
public class LoginParam {
    /**
     * 用户登录名称
     */
    @NotEmpty(message = "loginName不能为空")
    private String loginName;
    /**
     * 登录密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 验证码
     */
    private String veriCode;

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

    public String getVeriCode() {
        return veriCode;
    }

    public void setVeriCode(String veriCode) {
        this.veriCode = veriCode;
    }
}
