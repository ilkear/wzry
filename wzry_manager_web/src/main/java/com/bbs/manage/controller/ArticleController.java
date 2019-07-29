package com.bbs.manage.controller;

import com.bbs.domain.Article;

import com.bbs.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(Model model){

        ModelAndView mv = new ModelAndView();
        List<Article> article=articleService.findByPage();

        mv.addObject("article",article);
        mv.setViewName("ArticlePage");

        return mv;
    }
            //屏蔽功能
    @RequestMapping(value = "/updateReport.do")
    public String updateReport(@RequestParam(value = "articleId") Integer articleId,@RequestParam(value = "isReport") Integer isReport){
        articleService.updateReport(articleId,isReport);
        return "redirect:/article/findByPage.do";
    }
        //是否顶置
    @RequestMapping(value = "/updateTop.do")
    public String updateTop(@RequestParam(value = "articleId") Integer articleId,@RequestParam(value = "isTop") Integer isTop){
        articleService.updateTop(articleId,isTop);
        return "redirect:/article/findByPage.do";
    }


//模糊查询
    @RequestMapping(value = "/likeArticle.do")
    public ModelAndView likeArticle(String title,String sendername){
        ModelAndView mv = new ModelAndView();
        List<Article> like = articleService.likeArticleList(title,sendername);

//        article.setSenderName("%"+article.getSenderName()+"%");
//        article.setTitle("%"+article.getTitle()+"%");


        mv.addObject("article",like);
        mv.setViewName("ArticlePage");
        return mv;
    }

}
