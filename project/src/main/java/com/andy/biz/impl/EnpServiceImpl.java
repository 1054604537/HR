package com.andy.biz.impl;

import com.andy.biz.EmpService;
import com.andy.dao.EmpMapper;
import com.andy.model.Dept;
import com.andy.model.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
@Service
public class EnpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> allEmp() {
        return empMapper.allEmp();
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }

    @Override
    public boolean addEmp(Emp emp) {
       empMapper.addEmp(emp);
       return true;
    }

    @Override
    public Emp getEmp(Emp emp) {
        return empMapper.getEmp(emp);
    }

    @Override
    public Emp find(Emp emp) {
        return empMapper.find(emp);
    }

    @Override
    public Emp empToDeptAndJob(Emp emp) {
        return empMapper.empToDeptAndJob(emp);
    }

    @Override
    public boolean updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public List<Emp> getInfo(Emp emp) {
        return empMapper.getInfo(emp);
    }

    @Override
    public boolean updatepass(Emp emp) {
        return empMapper.updatepass(emp);
    }

    @Override
    public List<Emp> allEmpByDdept() {
        return empMapper.allEmpByDdept();
    }

    @Override
    public boolean updateRelieve(Emp emp) {
        return empMapper.updateRelieve(emp);
    }


    @Override
    public Emp findSal(Emp emp) {
        return empMapper.findSal(emp);
    }
}
