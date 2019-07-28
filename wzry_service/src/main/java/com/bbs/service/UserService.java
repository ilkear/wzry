package com.bbs.service;

import com.bbs.domain.User;
import com.bbs.domain.Zoneapply;

import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
public interface UserService {

    /**
     * 通过用户名获取用户
     * @return
     */
    User findUserByUsername(String name);

    /**
     * 修改用户的头像
     * @param picurl  上传的头像路径
     * @param userName 用户的name
     */
    void savePicUrl(String picurl, String userName);

    /**
     * 修改用户email
     * @param userName
     * @param email
     * @return
     */
    Long saveEmail(String userName, String email);

    void login(User user);

    void logout(User user);

    List<User> findOnlineUser();

    int countStatus();
}
