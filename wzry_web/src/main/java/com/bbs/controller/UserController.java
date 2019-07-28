package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.io.File;
import java.util.List;


/**
 * @author : Xiaos.Lyn
 * @date : 2019/7/27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public String login(User user, HttpSession session) {

        User u = userService.findUserByUsername(user.getUserName());
        if (u != null && u.getUserPass().equals(user.getUserPass())) {

            u.setLastLoginTime(new Date());
            //保存上次登录时间
            userService.login(u);
            session.setAttribute("user",u);
        }

        return "redirect:/index.jsp";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.logout(user);
        session.invalidate();
        return "redirect:/index.jsp";
    }

    /**
     * 打开个人中心
     * @return
     */
    @RequestMapping("/userInfo.do")
    public String userInfo() {
        return "userInfo";
    }

    /**
     * 修改个人信息
     * @return
     */
    @RequestMapping("/updateUserInfo.do")
    public String updateUserInfo(HttpServletRequest request) throws Exception {
        System.out.println("updateUserInfo执行了");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        // 创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        // 遍历
        for (FileItem fileItem : list) {
            // 判断文件项是普通字段，还是上传的文件
            if (fileItem.isFormField()) {
                //是普通字段
                if ("userName".equals(fileItem.getFieldName())) {
                    userName = fileItem.getString();
                }
                if ("email".equals(fileItem.getFieldName())) {
                    email = fileItem.getString();
                }

            } else {
                //是文件
                // 上传文件项
                // 获取到上传文件的名称
                String filename = fileItem.getName();
                // 上传文件
                if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".bmp") || filename.endsWith(".png")) {
                    fileItem.write(new File(file, filename));
                    userService.savePicUrl("uploads/" + filename, userName);
                } else {
                    System.out.println("文件格式不正确,不保存");
                }
                // 删除临时文件
                fileItem.delete();
            }
        }
        if (email == null || email.length() == 0) {
            request.setAttribute("emailmsg", "邮箱地址不能为空!");
            return "forward:/jsp/userInfo.jsp";
        } else {
            Long count = userService.saveEmail(userName, email);
            if (count >= 1) {
                request.setAttribute("emailmsg", "修改成功!");
            }

        }

        return "forward:/jsp/userInfo.jsp";
    }

    @RequestMapping("/userPwd.do")
    public String userPwd(String oldPassword,String newPassword){


        return "forward:/jsp/userInfo.jsp";
    }


}
