package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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


    /**
     * 查询贴所有
     * @return
     */

    @Select("SELECT * FROM `bbs_article_table`")
    public List<Article> findByPage();

    /**
     *屏蔽帖子
     * @param articleId
     * @param isReport
     */
    @Update("update `bbs_article_table` set isReport=#{isReport} where articleId=#{articleId}")
    public void updateReport(@Param("articleId") Integer articleId, @Param("isReport") Integer isReport);

    /**
     *顶置帖子
     * @param articleId
     * @param isTop
     */
    @Update("update `bbs_article_table` set isTop=#{isTop} where articleId=#{articleId}")
    public void updateTop(@Param("articleId") Integer articleId, @Param("isTop") Integer isTop);

    /**
     * 模糊查询结果
     * @return
     */

    public List<Article> likeArticleList(@Param("title") String title,@Param("senderName") String senderName);
}
