package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
            session.setAttribute("user",u);
        }
        return "redirect:/index.jsp";
    }

}
