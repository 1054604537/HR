package com.andy.controller;

import com.andy.biz.*;
import com.andy.model.*;
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
import java.io.PrintWriter;
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
    @Resource
    private InviteService inviteService;

    @RequestMapping("/addUser")
    public String addUser(String name, String pass, String email,Model model){
        System.out.println("用户注册后台");
        User user=new User();
        user.setU_name(name);
        user.setU_pass(pass);
        user.setU_email(email);
        System.out.println(user);

        User user1=new User();
        user1.setU_name(name);

        User user2=userService.getUser(user1);
       if (user2==null){
           userService.addUser(user);
           return "login";
       }else {
           model.addAttribute("error","用户名存在");
           return "error";
       }
    }

    @RequestMapping("/login2")
    public String login2(){
        return "login";
    }
    @RequestMapping("/login")
    //用户登录
    public String login(String name, String pass, Model model,HttpSession session){
        System.out.println("后台登录界面");
        List<User> list=userService.allUser();
        User user1=userService.fingUserByName(name);
        for (User user:list){
            if (user.getU_name().equals(name)&&user.getU_pass().equals(pass)){
                session.setAttribute("user",user1);
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
    public String addre(Resume resume,Model model,HttpServletRequest request,HttpSession session){
        User user= (User) session.getAttribute("user");
       // int uid= Integer.parseInt(request.getParameter("uid"));
        resume.setU_id(user.getU_id());
        System.out.println("添加个人简历");
        String phone=resume.getR_phone();
        System.out.println(phone+"xxxxxxxxxxxxxxx");
        Resume resume1=new Resume();
        resume1.setU_id(user.getU_id());
        Resume resume2=resumeService.getResume(resume1);

        Resume ss=resumeService.getPhone(resume);
        if (ss!=null){
            model.addAttribute("notphone","手机号码已经注册");
            return "error";
        }else{
            if (resume2!=null){
                System.out.println("xxxxxxxxxxxxxxxx");
                session.setAttribute("resumeIsnull","已存在简历，返回首页前往查看,或手机号码已经被注册");
                return "error";
            }else{
                System.out.println("ssssssssssbbbbbbbbb");
                model.addAttribute("resume",resume);//存简历
                resumeService.addResume(resume);//添加简历
                System.out.println(resume);
                return "success";
            }
        }


    }
    @RequestMapping("/updateResume")
    public String updateResume(HttpServletRequest request,HttpSession session) throws ParseException {
        System.out.println("来到修改简历");
        User user= (User) session.getAttribute("user");
        String descrption=request.getParameter("descrption");
        Resume resume=new Resume();
        resume.setU_id(user.getU_id());
        resume.setR_description(descrption);

        resumeService.updateResume(resume);
        System.out.println(resume);
        return "success";

    }

    @RequestMapping("/seeresumne")
    public String seeresumne(Model model,HttpSession session){
        User user= (User) session.getAttribute("user");
        System.out.println(user);
        System.out.println("查看个人简历");
        List<Resume> list=resumeService.allResume(user.getU_id());
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

        System.out.println("查看全部公司招聘信息");
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
              System.out.println("5555555555555555555555555");
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

    @RequestMapping("/message")
    public String messageUser(HttpSession session,Model model){
        System.out.println("来到我的消息");
       User user= (User) session.getAttribute("user");

        Invite invite=new Invite();
        invite.setI_uid(user.getU_id());
        List<Invite> list1=inviteService.userMassageByUid(invite);
        model.addAttribute("invite1",list1);
        System.out.println(list1+"list1wwww");
        return "userMessage";
    }

    @RequestMapping("/accept")
    public String accept(HttpSession session,HttpServletRequest request){
        System.out.println("接受面试");
            User user= (User) session.getAttribute("user");
            Invite invite=new Invite();

            invite.setI_isno_accept("接受面试");//成为员工。。。
            invite.setI_allo("未分配");
            invite.setI_uid(user.getU_id());



            Invite invite1=inviteService.getInvite(invite);
            System.out.println(invite1);

            inviteService.isOrNoAccept(invite);//接受
            inviteService.updateAlllo(invite);//状态时未分配。。

            return "success";
        }
    @RequestMapping("/userSeeAllRecruit")
    public String userSeeAllRecruit(HttpSession session){
        List<Recruit>list=recruitService.allRecruit();
        if (list.size()!=0){
            session.setAttribute("seeAllRecruit",list);
            return "userSeeAllRecruit";
        }else if(list.size()==0) {
            session.setAttribute("error","无发布信息");
            return "userSeeAllRecruit";
        }
        return "";
    }
    @RequestMapping("/check1")
    public void check(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("name");
        PrintWriter pw=response.getWriter();
        System.out.println("1111111111113zxxxx");
            if ("111".equals(name)){
                pw.print(true);
            }else {
                pw.print(false);
            }
    }
    @RequestMapping("/index")
    public String index(){
        return "../../index";
    }
    @RequestMapping("/indexUserHome")
    public String indexUserHome(){
        return "success";
    }
}
