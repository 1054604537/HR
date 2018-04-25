package com.andy.dao;

import com.andy.model.Dept;

import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
public interface DeptMapper {
    List<Dept> allDept();//全部部门
    boolean saveDept(Dept dept);//添加部门
    boolean deleteDept(Dept dept);//删除部门---id
    Dept getDept(Dept dept);
}
