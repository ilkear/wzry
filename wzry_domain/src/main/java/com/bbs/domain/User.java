package com.bbs.domain;

import java.util.Date;

public class User {
    //用户ID
    Integer userId;
    //用户名
    String userName;
    //密码
    String userPass;
    //邮箱
    String email;
    //头像
    String picUrl;
    //1代表普通用户；2代表高级用户，3代表超级管理员
    Integer role;
    //最后登录时间
    Date lastLoginTime;
   //登录状态，0代表未登录，1代表已登录
    Integer loginStatus;
    //发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
    Integer talkStatus;
   //申请升级(0-未申请,1-已申请)
    Integer isupdating;
   //申请升级审核状态(0-未处理,1-已处理)
    Integer updateStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Integer getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(Integer talkStatus) {
        this.talkStatus = talkStatus;
    }

    public Integer getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(Integer isupdating) {
        this.isupdating = isupdating;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }
}
