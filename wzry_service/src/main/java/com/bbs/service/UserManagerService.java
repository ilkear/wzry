package com.bbs.service;

import com.bbs.domain.UserInfo;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserManagerService {
    UserInfo login(String username,String userpass);


    List<UserInfo> findAll(Integer page,Integer size);

    UserInfo queryUser(String username, Integer role);

    void updateRole(Integer userId, Integer role);

    void updateTalkStatus(Integer userId, Integer talkStatus);

    List<UserInfo> findByCondition(String userName,Integer role,Integer page,Integer size);

}
