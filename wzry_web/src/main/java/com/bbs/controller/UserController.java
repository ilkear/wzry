package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@SessionAttributes
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public ModelAndView login(User user){
        ModelAndView mv = new ModelAndView();

        User u = userService.findUserByUsername(user.getUserName());
        if(u==null || u.getUserPass().equals(user.getUserPass())){
            //找不到或者密码不正确,滚回主页
            mv.setViewName("index");
            return mv;
        }else {
            mv.addObject("user",u);
        }
        mv.setViewName("redirect:/index.jsp");
        return mv;
    }

}
