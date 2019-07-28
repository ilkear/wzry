package com.bbs.dao;

import com.bbs.domain.User;

import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface UserDao {


    //查询用户表
    @Select("select * from bbs_user_table")
    public List<User> findOnlineUser() throws Exception;


    @Select("SELECT * FROM `bbs_user_table` WHERE userName=#{userName}")
    User findUserByUsername(String name);

    @Select("SELECT COUNT(loginStatus) FROM bbs_user_table WHERE `loginStatus`=1")
    int CountUser();

    @Update("UPDATE `bbs_user_table` SET loginStatus=1,lastLoginTime=#{lastLoginTime} WHERE userId=#{userId}")
    void login(User user);

    @Update("UPDATE `bbs_user_table` SET loginStatus=0 WHERE userId=#{userId}")
    void logout(User user);
}
