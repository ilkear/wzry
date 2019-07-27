package com.bbs.dao;
import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
@Repository
public interface CommentDao {

    @Select("SELECT * FROM `bbs_comment_table` WHERE `articleId` = #{articleId}")
    List<Comment> getCommentByArticleId(Integer articleId);

    @Select("select count(articleId) from bbs_article_table where senderName=${userName}")
    Integer getUserSun(@Param("userName") String userName);


}
