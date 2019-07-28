package com.bbs.domain;


import java.util.Date;
import com.bbs.utils.DateUtils;
public class UserInfo {
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

    String talkStatusStr;

    String lastLoginTimeStr;
    String roleStr;
    String isupdatingStr;

    public String getIsupdatingStr() {
        if (isupdating == 0){
            isupdatingStr ="未处理";
        }
        if (isupdating == 1){
            isupdatingStr ="已处理";
        }
        return isupdatingStr;
    }

    public void setIsupdatingStr(String isupdatingStr) {
        this.isupdatingStr = isupdatingStr;
    }

    public String getRoleStr() {
        //1代表普通用户；2代表高级用户，3代表超级管理员
        if (role == 1){
            roleStr ="普通用户";
        }
        if (role == 2){
            roleStr ="高级用户";
        }
        if (role == 3){
            roleStr ="超级管理员";
        }
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public String getLastLoginTimeStr() {
        if (lastLoginTime != null){
            lastLoginTimeStr = DateUtils.date2String(lastLoginTime,"yyyy-MM-dd HH:mm:ss");
        }
        return lastLoginTimeStr;
    }

    public void setLastLoginTimeStr(String lastLoginTimeStr) {
        this.lastLoginTimeStr = lastLoginTimeStr;
    }

    public String getTalkStatusStr() {
        //发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
        if (talkStatus == 1){
            talkStatusStr ="是";
        }
        if (talkStatus == 0){
            talkStatusStr ="否";
        }
        return talkStatusStr;
    }

    public void setTalkStatusStr(String talkStatusStr) {
        this.talkStatusStr = talkStatusStr;
    }

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
