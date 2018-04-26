package com.andy.biz;

import com.andy.model.Dept;

import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
public interface DeptService {
    List<Dept> allDept();//全部部门
    boolean saveDept(Dept dept);//添加部门
    Dept getDept(Dept dept);
    boolean deleteDept(Dept dept);//删除部门---id
    List<Dept> deptToJob();//部门的一对多
}
