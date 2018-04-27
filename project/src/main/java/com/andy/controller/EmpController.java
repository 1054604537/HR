package com.andy.controller;

import com.andy.biz.DeptService;
import com.andy.biz.EmpService;
import com.andy.biz.JobService;
import com.andy.biz.TrainService;
import com.andy.model.Dept;
import com.andy.model.Emp;
import com.andy.model.Job;
import com.andy.model.Train;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/empLogin")
    public String empLogin(){
       return "empLogin";
    }
    @RequestMapping("/empLogin1")
    public String empLogin1(HttpServletRequest request, HttpSession session){
        System.out.println("员工登录");
        String eid= (request.getParameter("name"));
        List<Emp>list=empService.allEmp();
        for (Emp emp:list){
            if (emp.getE_id().equals(eid)){
                Emp emp1=new Emp();
                emp1.setE_id(eid);
                Emp emp2 =empService.find(emp1);
                session.setAttribute("emp",emp2);
                return "empLoginSuccess";
            }else
                return "empLogin";
        }
      return "";
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
    public String seePerformance(HttpSession session){
        return "seePerformance";
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
}
