package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Repository
public interface UserDao {
    @Select("SELECT * FROM `bbs_user_table` WHERE userName=#{userName}")
    User findUserByUsername(String name);
}
