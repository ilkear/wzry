package com.bbs.service;

import com.bbs.domain.User;

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
}
