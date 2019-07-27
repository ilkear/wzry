package com.bbs.controller;

import com.bbs.dao.CommentDao;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/publish.do")
    public ModelAndView publish(String userName){
        ModelAndView mv = new ModelAndView();
        int userSun = commentService.getUserSun(userName);
        mv.setViewName("userUpg");
        mv.addObject("publish",userSun);
        return mv;
    }
}
