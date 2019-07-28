package com.bbs.service.Impl;

import com.bbs.dao.ReplyDao;
import com.bbs.domain.Comment;
import com.bbs.domain.Reply;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public void addReply(Reply r) {
        replyDao.addReply(r);
    }

    @Override
    public Integer getArticleIdByCommentId(Integer commentId) {
        return replyDao.getArticleIdByCommentId(commentId);
    }
}
