package com.andy.controller;

import com.andy.biz.BossResumeService;
import com.andy.biz.ResumeService;
import com.andy.biz.UserService;
import com.andy.model.BossResume;
import com.andy.model.Resume;
import com.andy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 10546 on 2018/4/23.
 */
@Controller
public class AdminController {
    @Resource
    private UserService userService;
    @Resource
    private BossResumeService bossResumeService;
    @Resource
    private ResumeService resumeService;
    @RequestMapping("/adminlogin")
    public String adminlogin(){

     return "adminlogin";
    }
    @RequestMapping("/adminlogin1")
    public String adminlogin1(String name, String pass, Model model){

        System.out.println("管理员后台登录界面");

        List<User> list=userService.allUser();
        User user1=userService.fingUserByName(name);
        for (User user:list){
            if (user.getU_name().equals(name)&&user.getU_pass().equals(pass)){
                model.addAttribute("admin",user1);
                return "adminsuccess";
            }
        }
        return "adminlogin";
    }
    @RequestMapping("/seeallresumes")
    public String seeallresumes(Model model, HttpSession session){
        System.out.println("admin查看全部投递简历");
        List<BossResume> list=bossResumeService.allBossResume();
        String name=null;
        for (int i=0;i<list.size();i++){
            name=list.get(i).getBr_uname();
        }
        User user=new User();
        user.setU_name(name);
        User user1=userService.findUserToResumByName(user);
        int id =user1.getU_id();
        System.out.println(user1);

        List<Resume> resume=resumeService.findResumeByUid(id);
        model.addAttribute("resume",resume);
        if (list.size()!=0){
            model.addAttribute("bossresumes",list);
            return "seeBossResumes";
        }
        return "";
    }
//    @RequestMapping("/seeResumsDetail")
//    public String seeResumsDetail(String uname, Model model, HttpServletRequest request, Resume resume){
//        System.out.println( resume.getR_name()+"2222222222222222222");
//        System.out.println("admin查看投递人简历");
//        //String uname= request.getParameter("uname");
//        User user=new User();
//        user.setU_name(uname);
//        System.out.println(uname+"11111111111");
//        User user1=userService.findUserToResumByName(user);
//        System.out.println(user1);
//        if (user1!=null){
//            model.addAttribute("userdetail",user1);
//            return "seeBossResumes";
//        }
//        return "";
//    }
}
