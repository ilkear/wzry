package com.bbs.manage.controller;

import com.bbs.domain.Article;

import com.bbs.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(Model model){

        ModelAndView mv = new ModelAndView();
        List<Article> articles=articleService.findByPage();

        mv.addObject("articles",articles);
        mv.setViewName("arcticle");

        return mv;
    }

}
