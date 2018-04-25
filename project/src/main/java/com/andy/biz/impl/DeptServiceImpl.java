package com.andy.biz.impl;

import com.andy.biz.DeptService;
import com.andy.dao.DeptMapper;
import com.andy.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Override
    public List<Dept> allDept() {
        return deptMapper.allDept();
    }

    @Override
    public boolean saveDept(Dept dept) {
        deptMapper.saveDept(dept);
        return true;
    }

    @Override
    public Dept getDept(Dept dept) {
        return deptMapper.getDept(dept);
    }

    @Override
    public boolean deleteDept(Dept dept) {
        return deptMapper.deleteDept(dept);
    }
}
