package com.bbs.dao;

import com.bbs.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserManagerDao {
    //登录查询用户名和密码
    @Select("select * from bbs_user_table where username=#{username} and userpass=#{userpass}")
    UserInfo login(@Param("username") String username , @Param("userpass")String userpass);

    //查询所有信息
    @Select("select * from bbs_user_table")
    List<UserInfo> findAll();

    //升级用户组信息
    @Update("update bbs_user_table set role=#{role} where userId=#{userId}")
    void updateRole(@Param("userId") Integer userId,@Param("role") Integer role);

    //更新禁言
    @Update("update bbs_user_table set talkStatus=#{talkStatus} where userId=#{userId} ")
    void updateTalkStatus(@Param("userId") Integer userId,@Param("talkStatus") Integer talkStatus);

    //条件查询
    List<UserInfo> findByCondition(@Param("userName")String userName, @Param("role")String role2);

}
