package com.bbs.domain;

import java.util.Date;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
public class Report {
    //id
    Integer reportId;
    //举报内容
    String reportContent;
    //举报时间
    Date reportTime;
    //举报人
    String reportUserName;
    //处理状态
    Integer reportStatus;
    //文章ID
    Integer articleId;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
