package com.bbs.service.Impl;

import com.bbs.dao.CommentDao;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public Integer getUserSun(String userName) {
        return commentDao.getUserSun(userName);
    }
}
