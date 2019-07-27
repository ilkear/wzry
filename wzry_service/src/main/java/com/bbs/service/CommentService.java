package com.bbs.service;

import com.bbs.domain.Comment;
/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
public interface CommentService {
    /**
     * 查询用户的总贴数
     *
     * @param userName
     * @return
     */
    Integer getUserSun(String userName);

    /**
     * 添加回帖信息
     *
     * @param c
     */
    void addComment(Comment c);
}




