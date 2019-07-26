package com.bbs.domain;

import java.util.Date;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
public class Comment {
    //评论编号
    Integer commentId;
    //评论内容
    String commentContent;
    //评论时间
    Date commentTime;
    //评论人
    String commentUserName;
    //评论状态，1代表屏蔽，0代表解除
    Integer commentStatus;
    //帖子编号
    Integer articleId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
