package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public String login(User user, HttpSession session) {

        User u = userService.findUserByUsername(user.getUserName());
        if (u != null && u.getUserPass().equals(user.getUserPass())) {

            u.setLastLoginTime(new Date());
            //保存上次登录时间
            userService.login(u);
            session.setAttribute("user",u);
        }

        return "redirect:/index.jsp";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.logout(user);
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
