package com.andy.controller;

import com.andy.biz.BossResumeService;
import com.andy.biz.RecruitService;
import com.andy.biz.ResumeService;
import com.andy.biz.UserService;
import com.andy.model.BossResume;
import com.andy.model.Recruit;
import com.andy.model.Resume;
import com.andy.model.User;
import com.sun.org.apache.bcel.internal.generic.I2F;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,true));
    }
    @Resource
    private ResumeService resumeService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private BossResumeService bossResumeService;
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
    //用户登录
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


    @RequestMapping("/addresume")
    public String addresume(int uid, Model model){
        System.out.println(uid);
        model.addAttribute("uid",uid);
        return "addresume";
    }

    @RequestMapping("/addre")
    public String addre(Resume resume,Model model,HttpServletRequest request){
        int uid= Integer.parseInt(request.getParameter("uid"));
        resume.setU_id(uid);
        System.out.println("添加个人简历");
        if(null!=resume){
            model.addAttribute("resume",resume);//存简历
            resumeService.addResume(resume);
            System.out.println(resume);
            return "success";
        }
        return "";
    }
    @RequestMapping("/seeresumne")
    public String seeresumne(Model model,int uid){
        System.out.println("查看个人简历");
        List<Resume> list=resumeService.allResume(uid);
        model.addAttribute("resume",list);
        System.out.println(list);
        return "seeresumne";
    }

    @RequestMapping("/deleteres")
    //    删除简历 根据的简历的id
    public String deleteres(Integer rid, Model model,Resume resume) throws Exception{
        System.out.println("删除简历");
        System.out.println(resume);
        System.out.println(rid);
        if(resumeService.deleteResume(rid)){
            model.addAttribute("resume",resume);
            return "success";
        }
      return "";
    }


    @RequestMapping("/seerecruit")
    public String seeRecruit(HttpSession session,int uid,Model model){
        System.out.println("查看全部公司简历");
        List<Recruit> list=recruitService.allRecruit();
        if (list.size()!=0){
            session.setAttribute("uid",uid);
            System.out.println(uid);
            model.addAttribute("recruit",list);//存入缓存
            return "seerecruit";
        }
        return " ";
    }
  @RequestMapping("/mailing")
//  往公司简历库投递简历
    public String mailingToBoss(HttpSession session,HttpServletRequest request){
          System.out.println("11111111");
          int uid= Integer.parseInt(request.getParameter("uid"));
          System.out.println(uid);

          User user=new User();
          user.setU_id(uid);
          User user1=userService.findUserByResume(user);
          String name=user1.getU_name();
          String email=user1.getU_email();
          List<Resume>list=user1.getResumes();
          String phone= null;
          for (int i = 0; i <list.size() ; i++) {
              phone=list.get(i).getR_phone();
          }
          SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
          String date=simpleDateFormat.format(new Date());
          Date date1=null;
          try {
              date1=simpleDateFormat.parse(date);
          } catch (ParseException e) {
              e.printStackTrace();
          }
          System.out.println(user1+"1111111111111111111111");
          BossResume bossResume=new BossResume();
          bossResume.setBr_uname(name);
          bossResume.setBr_uemail(email);
          bossResume.setBr_uphone(phone);
          String job=request.getParameter("job");
          bossResume.setBr_job(job);
          bossResume.setBr_date(date1);
          System.out.println(bossResume+"222222222222");
          if (null!=bossResume){
             bossResumeService.addBossResume(bossResume);
              return "success";
          }
          return "";
    }
    //用户修改密码。。。
    @RequestMapping("/updatepass")
    public String updatepass(int uid,Model model){
        model.addAttribute("uid",uid);
        return "updatepass";
    }
    @RequestMapping("updatepass2")//根据用户id修改密码
    public String updatepass(String newpass,int uid){
        System.out.println("修改密码...");
        User user=new User();
        user.setU_id(uid);
        user.setU_pass(newpass);
        userService.updatepass(user);
        System.out.println("ok");
        return "login";
    }
}
