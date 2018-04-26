package com.andy.controller;

import com.andy.biz.EmpService;
import com.andy.model.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public String seeEmp(HttpSession session, Model model){
        Emp emp= (Emp) session.getAttribute("emp");
        model.addAttribute("detail",emp);
        return "seeEmp";
    }
}
