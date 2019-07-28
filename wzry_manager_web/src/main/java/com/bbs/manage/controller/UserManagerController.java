package com.bbs.manage.controller;

import com.bbs.domain.UserInfo;
import com.bbs.service.UserManagerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import java.util.List;


@Controller
@RequestMapping("/userManager")
public class UserManagerController {
    @Autowired
    private UserManagerService service;

    //登录
    @RequestMapping("/login.do")
    public ModelAndView login(String username,String userpass) {
        ModelAndView mv = new ModelAndView();
        //调用service查询用户信息
        UserInfo userInfo = service.login(username,userpass);
       if (userInfo == null || userInfo.getRole() !=3){
           mv.addObject("errorMsg","权限不足");
           mv.setViewName("login");
           return mv;
       }
       mv.setViewName("main");
       return mv ;
     }


    //分页
   @RequestMapping("/findByPage.do")
    public  ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page ,
                                 @RequestParam(name = "size",required = true ,defaultValue = "5")Integer size
                                 ){
  //创建视图
   ModelAndView mv = new ModelAndView();
  List<UserInfo> userList = service.findAll(page,size);
  //分页bean
  PageInfo pageInfo = new PageInfo(userList);
  mv.addObject("pageInfo",pageInfo);
  mv.setViewName("user-list");
   return mv;
}


   //升级
    @RequestMapping("/updateRole.do")
    public String updateRole(Integer userId,Integer role){
                    service.updateRole(userId,role);
                     return "redirect:findByPage.do";
    }



    /*//条件查询
    @RequestMapping("/queryUser.do")
    public ModelAndView queryUser(String username,Integer role){
    ModelAndView mv = new ModelAndView();
    UserInfo userInfo =   service.queryUser(username,role);
    return mv;
    }*/

    @RequestMapping("/updateTalkStatus.do")
    public String updateTalkStatus(Integer userId,Integer talkStatus){
        service.updateTalkStatus(userId,talkStatus);
        return "redirect:findByPage.do";
    }

    @RequestMapping("/findByCondition")
    public ModelAndView findByCondition(String userName,Integer role,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page ,
                                        @RequestParam(name = "size",required = true ,defaultValue = "5")Integer size){
        ModelAndView mv = new ModelAndView();
       List<UserInfo> userlist = service.findByCondition(userName,role,page,size);

        PageInfo pageInfo = new PageInfo(userlist);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");

        return mv;
    }

}
