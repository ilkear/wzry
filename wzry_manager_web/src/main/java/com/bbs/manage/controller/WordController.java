package com.bbs.manage.controller;

import com.bbs.domain.Word;

import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {


    @Autowired
    private WordService wordService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(Model model){

        ModelAndView mv = new ModelAndView();
        List<Word> words=wordService.findByPage();

        mv.addObject("words",words);
        mv.setViewName("word");

//        for(Word w : words) {
//            System.out.println(w);
//        }

        return mv;
    }


    @RequestMapping(value = "/updateStatus.do")
    public String updateStatus(@RequestParam(value = "wordId") Integer wordId,@RequestParam(value = "status") Integer status, HttpServletRequest request, Model model){
        wordService.updateStatus(wordId,status);
        return "redirect:/word/findByPage.do";
    }


    @RequestMapping("/addWord.do")
    public String addWord(String word,HttpServletRequest request){

        String w = request.getParameter("adname");
        wordService.addWord(w);

        return "redirect:/word/findByPage.do";
    }
}
