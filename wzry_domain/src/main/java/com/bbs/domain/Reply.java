package com.bbs.domain;

import java.util.Date;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
public class Reply {

    //回复编号
    Integer replyId;
    //回复内容
    String replyContent;
    //回复时间
    Date replyTime;
    //回复人
    String replyUserName;
    //评论编号
    Integer commentId;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
