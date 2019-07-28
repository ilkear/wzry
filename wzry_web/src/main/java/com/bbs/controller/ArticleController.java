package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.bbs.service.Impl.ArticleServiceImpl;
import com.bbs.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    /**
     * 返回首页
     * @return
     */
    @RequestMapping("/getArticleList.do")
    public ModelAndView getArticleList(){
        ModelAndView mv = new ModelAndView();
        //获取帖子列表
        List<Article> list = articleService.getArticleList();
        //获取总贴数
        Integer total = articleService.findArticleCount();
        //获取今日贴数
        String time = DateUtils.date2String(new Date(), "yyyy-MM-dd");
        Integer todayCount = articleService.findTodayCount(time);

        mv.addObject("today",todayCount);
        mv.addObject("total",total);
        mv.addObject("list",list);

        mv.setViewName("index");
        return mv;
    }

    /**
     * 跳转到帖子详情页
     * @return
     */
    @RequestMapping("/getArticle.do")
    public ModelAndView getArticle(Integer articleId){
        ModelAndView mv = new ModelAndView();
        Article article = articleService.getArticle(articleId);
        mv.setViewName("getArticle");
        mv.addObject("article",article);
        return mv;
    }
}
