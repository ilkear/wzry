package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Upvote;
import com.bbs.domain.User;
import com.bbs.domain.Zone;
import com.bbs.service.ArticleService;
import com.bbs.service.Impl.ArticleServiceImpl;
import com.bbs.service.UserService;
import com.bbs.service.ZoneapplyService;
import com.bbs.utils.DateUtils;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    UserService userService;
    @Autowired
    ZoneapplyService zoneapplyService;

    /**
     * 返回首页
     *
     * @return
     */
    @RequestMapping("/getArticleList.do")
    public ModelAndView getArticleList() throws Exception {
        ModelAndView mv = new ModelAndView();
        //获取帖子列表
        List<Article> list = articleService.getArticleList();
        //获取总贴数
        Integer total = articleService.findArticleCount();
        //获取今日贴数
        String time = DateUtils.date2String(new Date(), "yyyy-MM-dd");
        Integer todayCount = articleService.findTodayCount(time);

        mv.addObject("today", todayCount);
        mv.addObject("total", total);
        mv.addObject("list", list);

        //版块遍历
        List<Zone> list2 = zoneapplyService.findAll();
        mv.addObject("zoneList", list2);


        //查询在线用户信息

        List<User> list1 = userService.findOnlineUser();
        mv.addObject("UserList", list1);
        mv.setViewName("index");

        //查询在线人数
        int count = userService.countStatus();
        mv.addObject("CountUser", count);
        return mv;
    }

    /**
     * 跳转到帖子详情页
     *
     * @return
     */
    @RequestMapping("/getArticle.do")
    public ModelAndView getArticle(Integer articleId) {
        ModelAndView mv = new ModelAndView();
        Article article = articleService.getArticle(articleId);
        mv.setViewName("getArticle");
        mv.addObject("article", article);
        return mv;
    }
    /**
     * 关键字查询
     */

    @PostMapping("/findAll.do")
    public ModelAndView findPrimaryKey(@RequestParam(name = "PrimayKey",required = true) String keyWord,@RequestParam(name = "zoneId",required = true,defaultValue = "1")int zoneId) throws Exception{
      ModelAndView mv=new ModelAndView();
      String title='%'+keyWord+'%';
      List<Article> keyWordList=zoneapplyService.findPrimaryKey(title,zoneId);
        PageInfo pageInfo =new PageInfo(keyWordList);
        mv.addObject("pageInfo",pageInfo);
//        mv.setViewName("");
        return mv;
    }
}
