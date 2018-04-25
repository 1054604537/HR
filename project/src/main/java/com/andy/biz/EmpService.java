package com.andy.biz;

import com.andy.model.Emp;

/**
 * Created by 10546 on 2018/4/24.
 */
public interface EmpService {
    boolean addEmp(Emp emp);
    Emp getEmp(Emp emp);//查看部门的人员
}
