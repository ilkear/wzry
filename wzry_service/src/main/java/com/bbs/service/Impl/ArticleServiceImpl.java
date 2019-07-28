package com.bbs.service.Impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.bbs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/26
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> getArticleList(){
        return articleDao.getArticleList();
    }

    @Override
    public Article getArticle(Integer articleId) {

        return articleDao.getArticle(articleId);
    }


    @Override
    public List<Article> findByPage() {
        return articleDao.findByPage();
    }

    @Override
    public Integer findArticleCount() {
        return articleDao.findArticleCount();
    }

    @Override
    public Integer findTodayCount(String date) {
        int todayCount =0;//如果今日没发表新帖子则返回0
        try {
            todayCount = articleDao.findTodayCount(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  todayCount;
    }

}
