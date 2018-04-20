package com.andy.controller;

import com.andy.biz.UserService;
import com.andy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/dumplicate")
    public String check(String username,HttpServletResponse response){

        List<User> list=userService.allUser();
        for (User user:list){
            if (user.getU_name().equals(username)){
                return "response.getWriter().write('存在了')";
            }else {
                return "response.getWriter().write('ok')";
            }

        }
        return null;
    }
    @RequestMapping("/addUser")
    public String addUser(String name, String pass, String email){
        System.out.println("用户注册后台");
        User user=new User();
        user.setU_name(name);
        user.setU_pass(pass);
        user.setU_email(email);
        System.out.println(user);
       if (null!=user){
           userService.addUser(user);
           return "login";
       }
        return "";
    }

    @RequestMapping("/login2")
    public String login2(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String name, String pass, Model model){
        System.out.println("后台登录界面");
        List<User> list=userService.allUser();
        User user1=userService.fingUserByName(name);
        for (User user:list){
            if (user.getU_name().equals(name)&&user.getU_pass().equals(pass)){
                model.addAttribute("user",user1);
                return "success";
            }
        }
        return "login";
    }
}
