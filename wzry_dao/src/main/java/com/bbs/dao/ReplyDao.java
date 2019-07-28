package com.bbs.dao;

import com.bbs.domain.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Repository
public interface ReplyDao {

    @Select("SELECT * FROM `bbs_reply_table` WHERE `commentId`=#{commentId}")
    List<Reply> getReplyByCommentId(Integer commentId);

    @Insert("INSERT INTO `bbs_reply_table` VALUES(NULL,#{replyContent},#{replyTime},#{replyUserName},#{commentId})")
    void addReply(Reply r);
}
