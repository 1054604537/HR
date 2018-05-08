package com.andy.biz;

import com.andy.model.Dept;
import com.andy.model.Emp;

import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
public interface EmpService {
    List<Emp> allEmp();
    Emp login(Emp emp);
    boolean addEmp(Emp emp);
    Emp getEmp(Emp emp);//查看部门的人员
    Emp find(Emp emp);
    Emp empToDeptAndJob(Emp emp);//对应的部门职位工做
    boolean updateEmp(Emp emp);//员工离职，隐藏名字
    List<Emp> getInfo(Emp emp);
    boolean updatepass(Emp emp);//修改密码
    Emp findSal(Emp emp);//查找本职位的工资
    List<Emp> allEmpByDdept();//全部的部门下对应的员工
    boolean updateRelieve(Emp emp);//员工换岗

}
