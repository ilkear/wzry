package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
@Repository
public interface ArticleDao {
    /**
     * 获取全部帖子
     * @return 帖子列表
     */
    @Select("SELECT * FROM `bbs_article_table`")
    public List<Article> getArticleList();

    /**
     * 通过id获取帖子，及其回复
     * @param articleId
     * @return
     */
    public Article getArticle(Integer articleId);
}
