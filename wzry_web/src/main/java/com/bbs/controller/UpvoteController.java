package com.bbs.controller;



import com.bbs.domain.Upvote;
import com.bbs.domain.User;
import com.bbs.service.UpvoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("upvote")
public class UpvoteController {
    @Autowired
    private UpvoteService upvoteService;

    @RequestMapping("/like.do")
    public void likeUpvote(Integer articleId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Upvote upvote = new Upvote();
        upvote.setUpvoteUserName(user.getUserName());//获取点赞的用户名
        upvote.setUpvoteArticleId(articleId);//帖子编号
        upvote.setIsUpvote(1);//点赞状态
        upvoteService.addUpvote(upvote);
    }

    @RequestMapping("/findByNameAndarticleId")
    @ResponseBody
    public String findByNameAndarticleId(@Param(value = "articleId") Integer articleId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Upvote upvote = new Upvote();
        if (user != null) {//如果用户存在,就获取用户名
            upvote.setUpvoteUserName(user.getUserName());
        } else {
            return "false";
        }

        upvote.setUpvoteArticleId(articleId);
        List<Upvote> list = upvoteService.findByNameAndarticleId(upvote);

        if (list.size() == 0 || list.get(0).getIsUpvote() == 0) {
            return "false";
        } else {
            return "true";
        }

    }
}
