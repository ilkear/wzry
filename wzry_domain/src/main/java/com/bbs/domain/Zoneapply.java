package com.bbs.domain;

public class Zoneapply {
    //ID
    Integer applyZoneId;
    //新增版块名字
    String zoneName;
    //用户名
    String userName;
    //申请原因
    String reason;
    //处理状态(未处理-0,已处理-1)
    Integer status;

    public Integer getApplyZoneId() {
        return applyZoneId;
    }

    public void setApplyZoneId(Integer applyZoneId) {
        this.applyZoneId = applyZoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
