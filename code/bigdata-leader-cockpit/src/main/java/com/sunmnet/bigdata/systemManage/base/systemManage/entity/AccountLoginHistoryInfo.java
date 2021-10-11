package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

public class AccountLoginHistoryInfo {
    private Integer id;

    private String account;//账号

    private String loginTime;//登陆时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}