package com.bbs.domain;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
public class Upvote {

    //点赞人
    String upvoteUserName;
    //点赞帖子
    Integer upvoteArticleId;
    //点赞状态，0代表未点赞，1代表已点赞（默认）
    Integer isUpvote;

    public String getUpvoteUserName() {
        return upvoteUserName;
    }

    public void setUpvoteUserName(String upvoteUserName) {
        this.upvoteUserName = upvoteUserName;
    }

    public Integer getUpvoteArticleId() {
        return upvoteArticleId;
    }

    public void setUpvoteArticleId(Integer upvoteArticleId) {
        this.upvoteArticleId = upvoteArticleId;
    }

    public Integer getIsUpvote() {
        return isUpvote;
    }

    public void setIsUpvote(Integer isUpvote) {
        this.isUpvote = isUpvote;
    }
}
