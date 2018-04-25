package com.andy.biz.impl;

import com.andy.biz.EmpService;
import com.andy.dao.EmpMapper;
import com.andy.model.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 10546 on 2018/4/24.
 */
@Service
public class EnpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public boolean addEmp(Emp emp) {
       empMapper.addEmp(emp);
       return true;
    }

    @Override
    public Emp getEmp(Emp emp) {
        return empMapper.getEmp(emp);
    }
}
