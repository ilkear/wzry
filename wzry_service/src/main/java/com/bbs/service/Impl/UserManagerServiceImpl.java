package com.bbs.service.Impl;

import com.bbs.dao.UserManagerDao;
import com.bbs.domain.UserInfo;
import com.bbs.service.UserManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Autowired
    private UserManagerDao dao;

    @Override
    public UserInfo login(String username, String userpass) {
        //根据用户名查询用户信息
        return dao.login(username, userpass);
    }
    //查询所有并分页
    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return dao.findAll();
    }

    @Override
    public UserInfo queryUser(String username, Integer role) {
        return null;
    }

    /*//更新User
    @Override
    public UserInfo queryUser(String username, Integer role) {
        return null;
    }*/

    //更新用户权限
    @Override
    public void updateRole(Integer userId, Integer role) {
        if (role == 1) {
            role = role + 1;
            dao.updateRole(userId, role);
        }

      /*  }
        if (role == 2){
            dao.updateRole(userId,role);
        }
        if (role == 3){
            dao.updateRole(userId,role);
        }*/


            //查询用户信息


    }

    @Override
    public void updateTalkStatus(Integer userId, Integer talkStatus) {
        if (talkStatus == 0){
            talkStatus = 1;
            dao.updateTalkStatus(userId,talkStatus);
        }else {
            talkStatus = 0;
            dao.updateTalkStatus(userId,talkStatus);
        }
    }

    @Override
    public List<UserInfo> findByCondition(String userName,Integer role,Integer page,Integer size) {
        String role2 =null;
        if (userName != null && userName!="" ){
            userName = "%"+userName+"%";


        }
        if (role != null){
            role2 = "%"+role+"%";
        }

        PageHelper.startPage(page, size);
        return dao.findByCondition(userName,role2);

    }
}
