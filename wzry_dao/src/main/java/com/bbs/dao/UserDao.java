package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Repository
public interface UserDao {
    @Select("SELECT * FROM `bbs_user_table` WHERE userName=#{userName}")
    User findUserByUsername(String name);

    @Update("UPDATE `bbs_user_table` SET loginStatus=1,lastLoginTime=#{lastLoginTime} WHERE userId=#{userId}")
    void login(User user);

    @Update("UPDATE `bbs_user_table` SET loginStatus=0 WHERE userId=#{userId}")
    void logout(User user);
}
