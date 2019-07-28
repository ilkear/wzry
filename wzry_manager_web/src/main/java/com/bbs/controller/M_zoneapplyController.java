package com.bbs.controller;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 版块审核
 */

@Controller
@RequestMapping("/zoneApply")
public class M_zoneapplyController {

    //    zoneApply/findByPage.do
    @Autowired
    private ZoneapplyService zoneapplyService;

    //查询所有版块
    @RequestMapping("/findByPage.do")
    public ModelAndView findBypage() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Zoneapply> list = zoneapplyService.findByPage();
        mv.addObject("ZoneList", list);
        mv.setViewName("Zoneapply");
        return mv;
    }

    /**
     * 版块审核后台处理
     */

    @RequestMapping("/zoneApply.do")
    public String upStatus(int status, int applyZoneId,Zone zone) throws Exception {

        zoneapplyService.upStatus(status, applyZoneId);
        if (status==1) {
            zoneapplyService.saveZone(zone);
        }
        
        return "redirect:findByPage.do";
    }

}
