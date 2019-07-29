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
     * 查询贴
     * @return
     */
    public List<Article> findByPage();

    /**
     *屏蔽帖子
     * @param articleId
     * @param isReport
     */
    public void updateReport(Integer articleId,Integer isReport);

    /**
     *顶置帖子
     * @param articleId
     * @param isTop
     */
    public void updateTop(Integer articleId,Integer isTop);

    /**
     * 模糊查询
     * @param title
     * @param
     * @return
     */
     public List<Article> likeArticleList(String title,String sendername);
}
