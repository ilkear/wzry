package com.bbs.service.Impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println(articleDao);
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
}
