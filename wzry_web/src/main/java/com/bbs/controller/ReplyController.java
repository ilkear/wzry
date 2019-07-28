package com.bbs.controller;

import com.bbs.domain.Reply;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping("/add.do")
    public String add(Reply r) {
        r.setReplyTime(new Date());
        replyService.addReply(r);

        return "redirect:/index.jsp";
    }
}
