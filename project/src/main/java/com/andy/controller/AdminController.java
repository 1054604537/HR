package com.andy.controller;

import com.alibaba.fastjson.JSONObject;
import com.andy.biz.*;
import com.andy.dao.DeptMapper;
import com.andy.dao.InviteMapper;
import com.andy.model.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10546 on 2018/4/23.
 */
@Controller
public class AdminController {
    @Resource
    private UserService userService;//用户
    @Resource
    private BossResumeService bossResumeService;//公司简历库
    @Resource
    private ResumeService resumeService;//简历
    @Resource
    private AdminService adminService;//管理员
    @Resource
    private InviteService inviteService;//邀请
    @Resource
    private EmpService empService;//员工
    @Resource
    private RecruitService recruitService;//招聘
    @Resource
    private DeptService deptService;//部门
    @Resource
    private JobService jobService;//职位
    @Resource
    private TrainService trainService;//培训
    @Resource
    private RewAndPubService rewAndPubService;

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
        invite.setI_isno_accept("未接受");
        invite.setI_allo("未分配");
        System.out.println("111111111111"+uid);
        inviteService.outInviteToUser(invite);
        session.setAttribute("invite",invite);//存入邀请表session
        return "adminsuccess";
    }


    @RequestMapping("/recruit")
    //管理发布招聘信息等
    public String recruit(Model model){
        List<Job>list=jobService.allJob();
        model.addAttribute("job",list);
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
                model.addAttribute("invites",invite);
            }else if (invites.size()==0){
                System.out.println("没有数据");
                model.addAttribute("error","没有录用的人员");
            }
        }
        List<User> users=userService.findUserById(uid);
        session.setAttribute("users", users);
        System.out.println(invites);
        return "allotToEmp";
    }
    @RequestMapping("/newAlloEmp")
    public String newAlloEmp(HttpSession session,HttpServletRequest request,Model model){
        System.out.println("来到录用");
        List<Dept> list=deptService.allDept();//职位
        Integer uid= Integer.parseInt(request.getParameter("uid"));
        int uid1=uid.intValue();
        System.out.println(uid+"111111");

        List<Resume>list1=resumeService.allResume(uid1);
        List<Job>jobList=jobService.allJob();
        model.addAttribute("dept",list);
        model.addAttribute("resume",list1);
        model.addAttribute("jobs",jobList);//职位的全部
        System.out.println(list1+"11111112312312");
        return "newAllotToEmp";
    }


    @RequestMapping("/addEmp")
    public String addEmp(HttpServletRequest request) throws Exception{
        System.out.println("来到分配。。。");
        String eid= (request.getParameter("id"));//员工编号
        String ename=request.getParameter("name");//员工姓名
        String esex=request.getParameter("sex");//员工性别
        String ephone= (request.getParameter("phone"));//手机号码

        String email=request.getParameter("email");//邮箱
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=simpleDateFormat.format(new Date());
        Date date1=simpleDateFormat.parse(date);
        int did= Integer.parseInt(request.getParameter("did"));//部门id
        int jid= Integer.parseInt(request.getParameter("jid"));//职位id
        Emp emp=new Emp();
        emp.setE_id(eid);
        emp.setE_name(ename);
        emp.setE_sex(esex);
        emp.setE_phone(ephone);
        emp.setE_email(email);
        emp.setD_id(did);
        emp.setJ_id(jid);
        emp.setE_joindate(date1);
        emp.setE_pass("111111");//默认密码为六个111111
        int uid= Integer.parseInt(request.getParameter("uid"));
        Invite invite=new Invite();
        invite.setI_uid(uid);
        if (empService.addEmp(emp)){
            invite.setI_allo("已分配");
            inviteService.updateAlllo(invite);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("/saveJob")
    public String saveJob(Model model){
        List<Dept>list=deptService.allDept();
        model.addAttribute("dept",list);
        return "saveJob";
    }
    @RequestMapping("/addJob")
    //添加职位 同名不能添加
    public String addJob(HttpServletRequest request,HttpSession session) throws Exception{
        String jname=request.getParameter("jname");
        Double jsal= Double.valueOf(request.getParameter("jsal"));
        String date=request.getParameter("date");
        String dname=request.getParameter("dname");//部门名称。。。。。
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse(date);
        Dept dept=new Dept();
        dept.setD_name(dname);
        Dept dept1=deptService.getDept(dept);
        int did=dept1.getD_id();//0111111111111111

        Job job=new Job();
        job.setJ_name(jname);
        job.setJ_date(date1);
        job.setJ_jsal(jsal);
        job.setD_did(did);

        Job job1=new Job();
        job1.setJ_name(jname);

        Job job2=jobService.getJob(job1);

        session.setAttribute("job",job);
        if (job2==null){
            jobService.saveJob(job);

            System.out.println("创建完成");
            return "adminsuccess";
        }else{
            session.setAttribute("nullJob","已存在职位");
            return "error2";
        }
    }

    @RequestMapping("/queryJob")
    public String queryJob(Model model,HttpSession session){
        try {
            List<Job>jobList=jobService.allJob();
            List<Dept>list=deptService.deptToJob();
            //List<Emp>empList=empService.allEmpByDdept();
            System.out.println(list);
            session.setAttribute("deptTojob",list);
            model.addAttribute("jobs",jobList);//存在的所有职位
           // model.addAttribute("empDept",empList);//部门存在的所有员工
            return "queryJob";
        } catch (Exception e) {
            e.printStackTrace();
        }
       return "";
    }
    @RequestMapping("/seeEmpByDept")
    public String seeEmpByDept(Model model,HttpSession session){
        List<Dept>deptList=deptService.allDept();
        if (deptList.size()==0){
            model.addAttribute("notDept","没有记录");
            return "error";
        }else if(deptList.size()!=0){
            model.addAttribute("deptlist",deptList);
            return "seeEmpByDept";
        }
        return " ";
    }

    @RequestMapping("/seeEmpAndDept")
    public String seeEmpAndDept(HttpSession session,HttpServletRequest request,Model model) {
        System.out.println("1111111+++++++emp");
        int did= Integer.parseInt(request.getParameter("did"));
        System.out.println(did);
        Dept dept=new Dept();
        dept.setD_id(did);
        List<Dept>list=deptService.empByDept(dept);
        System.out.println(list);
        if (list.size()!=0){
            for (Dept dept1:list){
                List<Emp>empList=dept1.getEmps();
                model.addAttribute("empanddept",empList);
                return "seeEmpAndDept";
            }
        }else if(list.size()==0){
            model.addAttribute("empanddept1","此职位没有人员");
            return "error";
        }
       return "";
    }

    @RequestMapping("/deleteJob")
    //删除职位 有人员不能删除
    public String deleteJob(Model model,HttpServletRequest request){

        System.out.println("来到职位的删除操作");
        try {
            List<Job>list=jobService.jobToEmp();
            int jid= Integer.parseInt(request.getParameter("jid"));
            Job job=new Job();
            job.setJ_id(jid);

            if (list.size()!=0){
                System.out.println("存在员工不能删除+11111111111111111");
                model.addAttribute("deleteJob","存在员工不能删除");
                return "error";
            }else if (list.size()==0){
                System.out.println("可以删除+2222222222");
                jobService.deleteJob(job);//删除职位信息
                return "adminsuccess";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    @RequestMapping("/allTrain")
    //现有的所有培训信息
    public String allTrain(Model model){
        System.out.println("来到所有培训讯息");
        try {
            List<Train> list=trainService.allTrain();
            List<Dept>list1=deptService.allDept();
            model.addAttribute("train",list);
            model.addAttribute("dept",list1);
            return "allTrain";
        } catch (Exception e) {
            e.printStackTrace();
        }
       return "";
    }
    @RequestMapping("/saveTrain")
    public String saveTrain(Model model){
        List<Dept> list1= null;
        try {
            list1 = deptService.allDept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("dept",list1);//选择发送的部门DID
        return "saveTrain";
    }
    @RequestMapping("/addTrain")
    public String addTrain(HttpServletRequest request) throws Exception{
        System.out.println("来到发布培训讯息");
        String theme=request.getParameter("theme");
        String content=request.getParameter("content");
        String startdate=request.getParameter("startdate");

        String enddate=request.getParameter("enddate");



        String site=request.getParameter("site");
        int did= Integer.parseInt(request.getParameter("did"));

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse(startdate);
        Date date2=simpleDateFormat.parse(enddate);

        Train train=new Train();
        train.setT_theme(theme);
        train.setT_content(content);
        train.setT_startdate(date1);
        train.setT_enddate(date2);
        train.setT_site(site);
        train.setD_id(did);

        trainService.saveTrian(train);
        System.out.println("发布成功。。。");
        return "adminsuccess";
    }
    @RequestMapping("/deleteTrain")
    public String deleteTrain(HttpServletRequest request){
        try {
            int did= Integer.parseInt(request.getParameter("did"));
            Train train=new Train();
            train.setT_id(did);
            trainService.deleteTrian(train);
            System.out.println("删除成功。。。");
            return "adminsuccess";
        } catch (Exception e) {
            e.printStackTrace();
        }
      return "";
    }
    @RequestMapping("/addRewAndPub")
    //对员工进行奖惩
    public String addRewAndPub(){

        return "addRewAndPub";
    }

    @RequestMapping("/addRewAndPub1")
    //对员工进行奖惩
    public String addRewAndPub1(HttpServletRequest request)throws Exception{
        System.out.println("管理员对员工进行奖惩");
        String name=request.getParameter("name");
        int number= Integer.parseInt(request.getParameter("number"));
        String date= request.getParameter("date");
        String des=request.getParameter("descption");

        String eid=(request.getParameter("eid"));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Date date1=simpleDateFormat.parse(date);

        RewAndPub rewAndPub=new RewAndPub();
        rewAndPub.setP_type(name);
        rewAndPub.setP_number(number);
        rewAndPub.setP_date(date1);
        rewAndPub.setE_id(eid);
        rewAndPub.setP_descrption(des);
        rewAndPubService.addRewAndPub(rewAndPub);
        return "adminsuccess";
    }
    @RequestMapping("/seeAllEmpRewAndPub")
    //查看奖惩
    public String seeAllEmpRewAndPub(Model model){
        List<RewAndPub>list=rewAndPubService.allRewAndPub();
        if (list.size()==0){
            model.addAttribute("seeAllEmpRewAndPubIsNull",list);
            return "error";
        }else if(list.size()!=0){
            model.addAttribute("seeAllEmpRewAndPub",list);

            return "seeAllEmpRewAndPub";
        }
        return null;
    }
    @RequestMapping("/deleteRew")
    public String deleteRew(HttpServletRequest request){
        int pid= 0;
        try {
            pid = Integer.parseInt(request.getParameter("pid"));
            RewAndPub rewAndPub=new RewAndPub();
            rewAndPub.setP_id(pid);
            rewAndPubService.deleteRew(rewAndPub);
            System.out.println("删除成功");
            return "adminsuccess";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
       return "";
    }
    @RequestMapping("/all")
    public String seeAll(){
        return "seeAll";
    }
    @RequestMapping("/ajaxListAllDept")
    public void ajaxListAllDept(Model model,HttpServletRequest request,HttpServletResponse response
    ) throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");


        Map<String,Object> jsonObj=new HashMap<>();

        List<Dept> list=deptService.allDept();
        jsonObj.put("resultList",list);

        JSONObject json=new JSONObject(jsonObj);
        response.getWriter().print(json);
        System.out.println(json);
    }




    @RequestMapping("/ajaxFindJobByDept")
    public void ajaxFindJobByDept(HttpServletRequest request,HttpServletResponse response,Dept dept) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        System.out.println(dept+"11111111");
        if (dept.getD_id()==0){
            dept.setD_id(1);
        }
        Dept dept2=new Dept();
        dept2.setD_id(dept.getD_id());
        Dept dept1=deptService.findDept(dept);
        List<Job>jobList=dept1.getJobs();
        Map<String,Object> jsonObj=new HashMap<>();

        jsonObj.put("resultJob",jobList);

        System.out.println(dept1);
        JSONObject json=new JSONObject(jsonObj);
        System.out.println(json);
        response.getWriter().print(json);
    }

    @RequestMapping("/relieve")
    public String relieve(HttpSession session,Model model,HttpServletRequest request,HttpServletResponse response){
        //员工的换岗
        List<Emp> allEmp=empService.allEmp();
        if (null!=allEmp){
            session.setAttribute("allEmp",allEmp);//全部的员工
        }

     return "relieve" ;
    }

    @RequestMapping("empRelieve")
    public String empRelieve(HttpServletRequest request,HttpSession session){
        int e_eid= Integer.parseInt(request.getParameter("e_eid"));
        session.setAttribute("eid",e_eid);
        return "empRelieve";
    }

    @RequestMapping("empRelieve1")

    public String empRelieve1(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int eid= (int) session.getAttribute("eid");

        System.out.println("来到换岗");
        System.out.println(eid+"xxxxxxxxx");

            int d_id= Integer.parseInt(request.getParameter("deptId"));
            int j_id= Integer.parseInt(request.getParameter("jobId"));
            System.out.println(d_id+"111");
            System.out.println(j_id+"22");

            Emp emp=new Emp();
            emp.setE_eid(eid);
            emp.setD_id(d_id);
            emp.setJ_id(j_id);
            System.out.println(emp);
            empService.updateRelieve(emp);
            System.out.println("换岗成功");
            return "adminsuccess";


    }
}
