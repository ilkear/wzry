package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping("/getArticleList.do")
    public ModelAndView getArticleList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
