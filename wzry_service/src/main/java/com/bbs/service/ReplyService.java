package com.bbs.service;

import com.bbs.domain.Comment;
import com.bbs.domain.Reply;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
public interface ReplyService {
    void addReply(Reply r);

    Integer getArticleIdByCommentId(Integer commentId);
}
