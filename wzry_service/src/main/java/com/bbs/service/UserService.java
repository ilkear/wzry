package com.bbs.service;

import com.bbs.domain.User;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/28
 */
public interface UserService {

    /**
     * 通过用户名获取用户
     * @return
     */
    User findUserByUsername(String name);

    void login(User user);

    void logout(User user);
}
