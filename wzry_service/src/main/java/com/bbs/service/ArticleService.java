package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
public interface ArticleService {

    /**
     * 获取所有帖子信息用于前端展示
     * @return
     */
    public List<Article> getArticleList();

    /**
     * 获取帖子详情页信息
     * @return
     */
    public Article getArticle(Integer articleId);


    /**
     * 查询帖
     * @return
     */
    public List<Article> findByPage();

    /**
     * 查询帖子总数
     * @return
     */
    Integer findArticleCount();

    /**
     * 查询今日发表贴子
     * @param date
     * @return
     */
    Integer findTodayCount(String date);
}
