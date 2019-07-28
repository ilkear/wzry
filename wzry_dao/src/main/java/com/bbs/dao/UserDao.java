package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Repository
public interface UserDao {


    //查询用户表
    @Select("select * from bbs_user_table")
    public List<User> findOnlineUser() throws Exception;


    @Select("SELECT * FROM `bbs_user_table` WHERE userName=#{userName}")
    User findUserByUsername(String name);

    /**
     * 修改用户email
     * @param userName
     * @param email
     * @return
     */
    @Update("update bbs_user_table set email=#{email} where userName=#{userName}")
    Long saveEmail(@Param("userName") String userName, @Param("email") String email);

    /**
     * 上传用户头像
     * @param picUrl
     * @param userName
     */
    @Update("update bbs_user_table set picUrl=#{picUrl} where userName=#{userName}")
    void savePicUrl(@Param("picUrl") String picUrl,@Param("userName") String userName);

    @Select("SELECT COUNT(loginStatus) FROM bbs_user_table WHERE `loginStatus`=1")
    int CountUser();

    @Update("UPDATE `bbs_user_table` SET loginStatus=1,lastLoginTime=#{lastLoginTime} WHERE userId=#{userId}")
    void login(User user);

    @Update("UPDATE `bbs_user_table` SET loginStatus=0 WHERE userId=#{userId}")
    void logout(User user);
}
