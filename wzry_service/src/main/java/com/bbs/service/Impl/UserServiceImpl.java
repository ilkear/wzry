package com.bbs.service.Impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findUserByUsername(String name) {
        return userDao.findUserByUsername(name);
    }


    @Override
    public void login(User user) {
        userDao.login(user);
    }

    @Override
    public void logout(User user) {
        userDao.logout(user);
    }
}
