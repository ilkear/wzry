package com.bbs.service.Impl;

import com.bbs.dao.CommentDao;
import com.bbs.domain.Article;
import com.bbs.domain.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public void addComment(Comment c) {
        commentDao.addComment(c);
    }

    @Override
    public Integer getUserSun(String userName) {
        return commentDao.getUserSun(userName);
    }
    /**
     * 发帖
     * @param article
     */
    @Override
    public void addPosted(Article article) {
        commentDao.addPosted(article);
    }
}
