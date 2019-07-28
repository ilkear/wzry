package com.bbs.controller;


import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ruan
 * @date : 2019/7/26 23:36
 */


@Controller
@RequestMapping("/zone")
public class ZoneapplyController {



    @Autowired
    private ZoneapplyService zoneapplyService;


    //新增版块
    @RequestMapping("/saveZoneapply.do")
    public String save(Zoneapply zoneapply) throws Exception {

        zoneapplyService.save(zoneapply);


        return "redirect:saveZoneapply.do";
    }



}


