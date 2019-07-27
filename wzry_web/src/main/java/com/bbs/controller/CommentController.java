package com.bbs.controller;

import com.bbs.dao.CommentDao;
import com.bbs.domain.Article;
import com.bbs.domain.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
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

    @RequestMapping("/posted.do")
    public String posted(Article article){
        commentService.addPosted(article);
        return "redirct:index.jsp";
    }

    @RequestMapping("/add.do")
    public String add(Comment c) {
        c.setCommentTime(new Date());
        service.addComment(c);

        return "redirect:/index.jsp";
    }
}
