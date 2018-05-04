package com.andy.controller;

import com.andy.biz.*;
import com.andy.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 10546 on 2018/4/26.
 */
//正式员工
@Controller
public class EmpController {
    @Resource
    private EmpService empService;
    @Resource
    private JobService jobService;
    @Resource
    private TrainService trainService;
    @Resource
    private DeptService deptService;
    @Resource
    private RewAndPubService rewAndPubService;
    @Resource
    private AttenceService attenceService;
    @RequestMapping("/empLogin")
    public String empLogin(){
       return "empLogin";
    }
    @RequestMapping("/empLogin1")
    public String empLogin1(HttpServletRequest request, HttpSession session){
        System.out.println("员工登录");
        String eid= (request.getParameter("name"));
        String pass=request.getParameter("pass");
        List<Emp>list=empService.allEmp();//全部用户资料
        System.out.println(pass);
        Emp emp=new Emp();
        emp.setE_id(eid);
        emp.setE_pass(pass);
        Emp emp1=empService.login(emp);
        if (emp1!=null){
            session.setAttribute("emp",emp1);
            return "empLoginSuccess";
        }else{
            return "empLogin";
        }
    }
    @RequestMapping("/empUpdatePass")
    public String empUpdatePass(){
        return "empUpdatePass";
    }
    @RequestMapping("/empUpdaPass")
    public String empUpdaPass(HttpSession session,HttpServletRequest request){
        System.out.println("来到修改密码");
        Emp emp= (Emp) session.getAttribute("emp");
        String pass=request.getParameter("pass");
        Emp emp1=new Emp();

        emp1.setE_eid(emp.getE_eid());
        emp1.setE_pass(pass);

        System.out.println(emp1);
        empService.updatepass(emp1);
        return "empLogin";
    }

    @RequestMapping("/seeEmp")
    //查看员工的个人信息
    public String seeEmp(HttpSession session, Model model){
        Emp emp= (Emp) session.getAttribute("emp");
        model.addAttribute("detail",emp);
        return "seeEmp";
    }
    @RequestMapping("seePerformance")
    //查看员工的绩效
    public String seePerformance(HttpSession session,Model model){
        System.out.println("来到绩效");
        Emp emp= (Emp) session.getAttribute("emp");
        RewAndPub rewAndPub=new RewAndPub();
        System.out.println(emp);
        rewAndPub.setE_id(emp.getE_id());
        List<RewAndPub>list=rewAndPubService.empToRewAndPub(rewAndPub);
        if (list.size()!=0){
            System.out.println("11111111111111");
            model.addAttribute("empToRewAndPub",list);
            return "seePerformance";
        }else if(list.size()==0){
            model.addAttribute("empToRewAndPubIsMull","无数据");
            return "error";
        }
       return "";
    }
    @RequestMapping("/seeDeptAndJob")
    public String seeDeptAndJob(HttpSession session){
        System.out.println("来到员工查看所在的部门和职位");
        Emp emp= (Emp) session.getAttribute("emp");
        Emp emp1=  empService.empToDeptAndJob(emp);
        int jid=emp1.getJ_id();//职位id
        int did=emp1.getD_id();//部门id
        Job job=new Job();
        job.setJ_id(jid);
        System.out.println(emp1+"111111111");
        Job job1=jobService.getJobById(job);

        Dept dept=new Dept();
        dept.setD_id(did);

        Dept dept1=deptService.getDeptById(dept);
        System.out.println(job1+"222222222222");
        System.out.println(dept1+"33333333");
        session.setAttribute("seePerformance",emp1);
        session.setAttribute("job",job1);
        session.setAttribute("dept",dept1);
        return "seeDeptAndJob";
    }
    @RequestMapping("/seeTrain")
    //查看个人的培训(针对部门)
    public String seeTrain(HttpSession session){
        System.out.println("来到查看培训");
        Emp emp= (Emp) session.getAttribute("emp");
        Emp emp1=  empService.empToDeptAndJob(emp);
        int did=emp1.getD_id();//部门id
        Train train=new Train();
        train.setD_id(did);
        List<Train> list=trainService.getTrian(train);
        if (list.size()==0){
            session.setAttribute("error2","暂时没有培训消息，请等待通知");
            return "error";
        }else if (list.size()!=0){
            session.setAttribute("train",list);
            return "empSeeTrain";
        }
        return "";
    }
    @RequestMapping("/seeAttence")
    public String seeAttence(HttpSession session,Model model){
        //员工查看个人的考勤
        System.out.println("来到员工查看个人的考勤");
        Emp emp= (Emp) session.getAttribute("emp");

        Attence attence=new Attence();
        attence.setE_eid(emp.getE_eid());
        List<Attence> list=attenceService.allAttence(attence);
        if (list.size()==0){
            model.addAttribute("null11","没有数据");
            return "error";
        }
        if (list.size()!=0){
            model.addAttribute("seeAttence",list);
            model.addAttribute("emp",emp);
            return "seeAttence";
        }
        return "";
    }




    @RequestMapping("/dimission")
    //员工离职
    public String dimission(HttpSession session){
        System.out.println("来到员工离职");
        Emp emp= (Emp) session.getAttribute("emp");
        Emp emp1=new Emp();
        emp1.setE_eid(emp.getE_eid());
        emp1.setE_id("********已离职");

        empService.updateEmp(emp1);
        session.setAttribute("dimission","操作成功！");
        return "empLogin";
    }
    @RequestMapping("/detailList")
    //公司通讯录
    public String detailList(){
        System.out.println("公司通讯录");
        List<Emp> empList=empService.allEmp();
        List<Job> jobList=jobService.allJob();
        List<Dept> deptList=deptService.allDept();
        return "detailList";
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Emp> search(Emp emp) throws Exception{
        return empService.getInfo(emp);
    }
    @RequestMapping("/clockin")
    //上班打卡
    public String clockIn(HttpSession session) throws Exception{
        System.out.println("来到上班打卡");
        Emp emp= (Emp) session.getAttribute("emp");
        Attence attence=new Attence();

        RewAndPub rewAndPub=new RewAndPub();//奖惩记录

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH");
        String str=simpleDateFormat.format(date);
        int a=Integer.parseInt(str);
        Date date1=new Date();
        System.out.println(a+"111111111111");
        if (a>0&&a<=9){
            System.out.println("打卡+………………………………………………");
            SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat1.format(date1);
            attence.setA_type("上班正常");
        }
        else if (a>9&&a<12){
            System.out.println("打卡+2222");
            SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat1.format(date1);
            attence.setA_type("上班不正常");
//            不正常 迟到的话是要罚钱的  在奖罚的类型中添加一条迟到的数据
            System.out.println("来到迟到罚钱的页面 —+1111111");
                rewAndPub.setP_type("迟到");
                rewAndPub.setP_descrption("上班打卡迟到罚款");
                rewAndPub.setP_date(date1);
                rewAndPub.setP_number(-100);
                rewAndPub.setE_id(emp.getE_id());
                rewAndPubService.addRewAndPub(rewAndPub);
                System.out.println("迟到的罚钱的页面+22222222222");
        }else if(a>12&&a<24){
            System.out.println("打卡+3333");
            SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat1.format(date1);
            attence.setA_type("上班不正常");
//            不正常 迟到的话是要罚钱的  在奖罚的类型中添加一条迟到的数据
            System.out.println("超过12点来到矿工罚钱的页面 —+1111111");
            rewAndPub.setP_type("矿工");
            rewAndPub.setP_descrption("矿工");//矿工是扣除300
            rewAndPub.setP_date(date1);
            rewAndPub.setP_number(-300);
            rewAndPub.setE_id(emp.getE_id());
            rewAndPubService.addRewAndPub(rewAndPub);
            System.out.println("迟到的矿工的页面+22222222222");
        }
        attence.setA_clock_in(date);
        attence.setE_eid(emp.getE_eid());
        System.out.println(attence);

        attenceService.saveClockAttence(attence);
        return "empLoginSuccess";
    }

    @RequestMapping("/endin")
    //下班打卡
    public String endIn(HttpSession session) throws Exception{
        System.out.println("来到下班打卡");
        Emp emp= (Emp) session.getAttribute("emp");
        RewAndPub rewAndPub=new RewAndPub();//奖惩记录
        Attence attence=new Attence();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH");
        String str=simpleDateFormat.format(date);
        int a=Integer.parseInt(str);
        Date date1=new Date();
        if (a==18){
            SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat1.format(date1);
            attence.setA_type("下班正常");
        }else if(a>18&&a<20){
            SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat1.format(date1);
            attence.setA_type("加班");
            //不正常 迟到的话是要罚钱的  在奖罚的类型中添加一条迟到的数据
            System.out.println("来到迟到加班的页面 —+1111111");
            rewAndPub.setP_type("加班");
            rewAndPub.setP_descrption("加班奖励钱");
            rewAndPub.setP_date(date1);
            rewAndPub.setP_number(200);
            rewAndPub.setE_id(emp.getE_id());
            rewAndPubService.addRewAndPub(rewAndPub);
            System.out.println("加班的奖励的页面+22222222222");
        }
        else if (a<18){
            //早退
            SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat1.format(date1);
            attence.setA_type("下班不正常");
            System.out.println("早退的页面 —+1111111");
            rewAndPub.setP_type("早退");
            rewAndPub.setP_descrption("早退");
            rewAndPub.setP_date(date1);
            rewAndPub.setP_number(-200);
            rewAndPub.setE_id(emp.getE_id());
            rewAndPubService.addRewAndPub(rewAndPub);
            System.out.println("早退罚钱的页面+22222222222");
        }
        attence.setA_end_in(date1);
        attence.setE_eid(emp.getE_eid());
        System.out.println(attence);
        attenceService.endAttence(attence);
        return "empLoginSuccess";
    }


    //查看个人薪资
    @RequestMapping("/seeSal")
    public String seeSal(HttpSession session,Model model){
        System.out.println("来到结薪资");
        Emp emp= (Emp) session.getAttribute("emp");
        System.out.println(emp+"11111111");

        Job job=new Job();
        job.setJ_id(emp.getJ_id());

        Job job1=jobService.empToasal(job);
        Double sal=job1.getJ_jsal();//个人职位薪资
        model.addAttribute("jsal",sal);
        System.out.println(emp.getE_name()+"职位薪资为:"+job1.getJ_jsal());
        RewAndPub rewAndPub=new RewAndPub();
        rewAndPub.setE_id(emp.getE_id());
        List<RewAndPub> list=rewAndPubService.empToSalByLate(rewAndPub);//迟到
        if (list.size()!=0){
            model.addAttribute("rewpub",list);
        }else if(list.size()==0){
            model.addAttribute("notlate1","没有迟到记录");
            return "error";
        }
        List<RewAndPub> list2=rewAndPubService.empToSalBylate2(rewAndPub);//早退
        if (list2.size()!=0){
            model.addAttribute("rewpub2",list2);
        }else{
            model.addAttribute("notlate2","没有迟到记录");
            return "error";
        }


        System.out.println(list+"2222222222");

        return "seeSal";
    }
}
