package com.bbs.domain;

public class Zone {
    //版块编号
    Integer zoneId;
    //版块名字
    String zoneName;
    //'是否默认，1代表默认，2代表非默认',
    Integer isDef;

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }
}
