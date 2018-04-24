package com.andy.controller;

import com.andy.biz.*;
import com.andy.dao.DeptMapper;
import com.andy.dao.InviteMapper;
import com.andy.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private InviteMapper inviteMapper;
    @Resource
    private AdminService adminService;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private InviteService inviteService;
    @RequestMapping("/adminlogin")
    public String adminlogin(){

     return "adminlogin";
    }
    @RequestMapping("/adminlogin1")
    public String adminlogin1(String name, String pass, Model model){

        System.out.println("管理员后台登录界面");

        List<User> list=userService.allUser();
        List<Admin> list1=adminService.allAdmin();

        for (Admin admin:list1) {
            if(admin.getA_name().equals(name)&&admin.getA_pass().equals(pass)){
                model.addAttribute("admin",admin);
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
        model.addAttribute("uid",id);
        List<Resume> resume=resumeService.findResumeByUid(id);
        model.addAttribute("resume",resume);
        session.setAttribute("resume",resume);//session
            if (list.size()!=0){
                model.addAttribute("bossresumes",list);
                return "seeBossResumes";
            }
        return "";
    }
   @RequestMapping("/deleteboss")
    public String deleteboss(HttpServletRequest request,Model model, HttpSession session){
        int brid= Integer.parseInt(request.getParameter("brid"));
        bossResumeService.deleteBossResume(brid);
           return "adminsuccess";
       }
    @RequestMapping("/inviteToUser")
    public String inviteToUser(HttpSession session,HttpServletRequest request) throws Exception{
        String date= request.getParameter("date");
        String job=request.getParameter("job");
        String site=request.getParameter("site");
        String des=request.getParameter("descrption");
        int uid= Integer.parseInt(request.getParameter("uid"));
        Invite invite=new Invite();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1= simpleDateFormat.parse(date);
        invite.setI_date(date1);
        invite.setI_job(job);
        invite.setI_site(site);
        invite.setI_description(des);
        invite.setI_uid(uid);
        System.out.println("111111111111"+uid);
        inviteMapper.outInviteToUser(invite);
        session.setAttribute("invite",invite);//存入邀请表session
        return "adminsuccess";
    }

    @RequestMapping("/allotToEmp")
    //管理员分配员工信息  自动获取简历上字段 账号为注册手机号码
    public String adminAllotToEmp(Model model,HttpSession session){
        List<Invite> invites=inviteService.allInvite();//为入职人员
        int uid=0;
        for (Invite invite:invites){
            uid=invite.getI_uid();
        }
        List<User> users=userService.findUserById(uid);
        model.addAttribute("invites",invites);
        session.setAttribute("users", users);
        System.out.println(invites);
//        List<Dept> list=deptMapper.allDept();
//        session.setAttribute("dept",list);//全部部门 分配选择
//        System.out.println("分配入职员工的信息");
        return "allotToEmp";
    }
    @RequestMapping("/newAlloEmp")
    public String newAlloEmp(HttpSession session,HttpServletRequest request,Model model){
        System.out.println("来到分配职位工作");
        List<Dept> list=deptMapper.allDept();//职位
        //session.setAttribute("dept",list);//全部部门 分配选择
        // System.out.println("分配入职员工的信息");

        Integer uid= Integer.parseInt(request.getParameter("uid"));
        int uid1=uid.intValue();
        System.out.println(uid+"111111");
        //List<User>list1=userService.findUserByResume2(uid1);
        List<Resume>list1=resumeService.allResume(uid1);
        //session.setAttribute("userAndResumes",list1);
        model.addAttribute("resume",list1);
       // userService.findUserByResume();
        System.out.println(list1+"11111112312312");
        return "newAllotToEmp";
    }

}
