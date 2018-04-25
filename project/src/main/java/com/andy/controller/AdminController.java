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
    private InviteService inviteService;
    @Resource
    private EmpService empService;
    @Resource
    private RecruitService recruitService;

    @Resource
    private DeptService deptService;


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


    @RequestMapping("/recruit")
    //管理发布招聘信息等
    public String recruit(){
        return "addAecruit";
    }

    @RequestMapping("/addRecruit")
    public String addRecruit(HttpServletRequest request,HttpSession session){
        String name=request.getParameter("job");
        int number= Integer.parseInt(request.getParameter("number"));
        String education=request.getParameter("education");
        double sal= Integer.parseInt(request.getParameter("sal"));
        String descrption=request.getParameter("descrption");

        Recruit recruit =new Recruit();
        recruit.setJ_name(name);
        recruit.setRe_number(number);
        recruit.setRe_education(education);
        recruit.setRe_sal(sal);
        recruit.setRe_descrption(descrption);
        recruitService.addRecruit(recruit);
        System.out.println("添加成功");
        return "adminsuccess";
    }

    @RequestMapping("/allRecruit")
    public String allRecruit(HttpSession session){
        List<Recruit> list=recruitService.allRecruit();
        if (list.size()!=0){
            session.setAttribute("allRecruit",list);
            return "allRecruit";
        }else if(list.size()==0) {
            session.setAttribute("error","无发布信息");
            return "allRecruit";
        }
       return "";
    }
    @RequestMapping("deleteRecruit")
    public String deleteRecruit(HttpServletRequest request,HttpSession session){
        try {
            int rid= Integer.parseInt(request.getParameter("delete"));
            recruitService.deleteRecruit(rid);
            System.out.println(rid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminsuccess";
    }

    @RequestMapping("/allotToEmp")
    //管理员分配员工信息  自动获取简历上字段 账号为注册手机号码
    public String adminAllotToEmp(Model model,HttpSession session){
        List<Invite> invites=inviteService.allInvite();//为入职人员
        int uid=0;
        for (Invite invite:invites){
            uid=invite.getI_uid();
            if (invites.size()!=0){
                model.addAttribute("invites",invites);
            }else {
                model.addAttribute("error","没有为分配人员");
            }
        }
        List<User> users=userService.findUserById(uid);

        session.setAttribute("users", users);
        System.out.println(invites);

        return "allotToEmp";
    }
    @RequestMapping("/newAlloEmp")
    public String newAlloEmp(HttpSession session,HttpServletRequest request,Model model){
        System.out.println("来到分配职位工作");
        List<Dept> list=deptService.allDept();//职位
        Integer uid= Integer.parseInt(request.getParameter("uid"));
        int uid1=uid.intValue();
        System.out.println(uid+"111111");

        List<Resume>list1=resumeService.allResume(uid1);

        model.addAttribute("dept",list);
        model.addAttribute("resume",list1);

        System.out.println(list1+"11111112312312");
        return "newAllotToEmp";
    }
    @RequestMapping("/addEmp")
    public String addEmp(HttpServletRequest request){
        System.out.println("来到分配。。。");
        String eid= (request.getParameter("id"));//员工编号

        String ename=request.getParameter("name");//员工姓名

        String esex=request.getParameter("sex");//员工性别

        String ephone= (request.getParameter("phone"));//手机号码


        String email=request.getParameter("email");//邮箱

        int did= Integer.parseInt(request.getParameter("did"));//部门id

        Emp emp=new Emp();
        emp.setE_id(eid);
        emp.setE_name(ename);
        emp.setE_sex(esex);
        emp.setE_phone(ephone);
        emp.setE_email(email);
        emp.setD_id(did);
        int uid= Integer.parseInt(request.getParameter("uid"));
        Invite invite=new Invite();
        invite.setI_uid(uid);
        if (empService.addEmp(emp)){
            invite.setI_allo("已分配");
            inviteMapper.updateAlllo(invite);
            return "adminsuccess";
        }
       return "";
    }


    @RequestMapping("/saveDept")
    public String saveDept(){
        return "saveDept";
    }
    @RequestMapping("/addDept")
    public String addDept(HttpServletRequest request,Model model) throws Exception{
        System.out.println("来到添加部门。。。。");
        Dept dept=new Dept();
        String name=request.getParameter("dept");

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=request.getParameter("date");
        Date date1=simpleDateFormat.parse(date);
        dept.setD_name(name);
        dept.setD_date(date1);

        Dept dept1=new Dept();
        dept1.setD_name(name);

        Dept dept2=deptService.getDept(dept1);
        if (dept2==null){
            deptService.saveDept(dept);
            return "adminsuccess";
        }else {
            model.addAttribute("error","重复部门");
            return "saveDept";
        }
    }


    @RequestMapping("/allDept")
    //全部部门（部门有员工不能删除）
    public String deleteDept(HttpSession session){
        List<Dept>list=deptService.allDept();//全部门
        session.setAttribute("dept",list);
        return "allDept";
    }

    @RequestMapping("/deDept")
    public String deDept(HttpSession session,HttpServletRequest request){
        System.out.println("来到删除部门 员工不能删除");
        try {
            int did= Integer.parseInt(request.getParameter("did"));
            System.out.println(did);
            Emp emp=new Emp();
            emp.setD_id(did);
            Emp emp1=empService.getEmp(emp);
            Dept dept=new Dept();
            dept.setD_id(did);
            if (emp1!=null){
                System.out.println("222222222");
                session.setAttribute("null","存在人员不能删除");
                return "allDept";
            }else{
                System.out.println("111111111+++++");
                deptService.deleteDept(dept);
                return "adminsuccess";
            }
           // System.out.println(emp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
