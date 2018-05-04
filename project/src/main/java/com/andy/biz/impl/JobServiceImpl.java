package com.andy.biz.impl;

import com.andy.biz.JobService;
import com.andy.dao.JobMapper;
import com.andy.model.Job;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/25.
 */@Service
public class JobServiceImpl implements JobService {
     @Resource
     private JobMapper jobMapper;
    @Override
    public boolean saveJob(Job job) {
        return jobMapper.saveJob(job);
    }

    @Override
    public Job getJob(Job job) {
        return jobMapper.getJob(job);
    }

    @Override
    public List<Job> allJob() {
        List<Job> list=jobMapper.allJob();
        if (list.size()!=0){
            return list;
        }
        return null;
    }

    @Override
    public List<Job> jobToEmp() {
        return jobMapper.jobToEmp();
    }

    @Override
    public boolean deleteJob(Job job) {
        return jobMapper.deleteJob(job);
    }

    @Override
    public Job getJobById(Job job) {
        return jobMapper.getJobById(job);
    }

    @Override
    public Job empToasal(Job job) {
        return jobMapper.empToasal(job);
    }
}
