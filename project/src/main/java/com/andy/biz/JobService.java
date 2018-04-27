package com.andy.biz;

import com.andy.model.Job;

import java.util.List;

/**
 * Created by 10546 on 2018/4/25.
 */
public interface JobService {
    boolean saveJob(Job job);//增加职位
    Job getJob(Job job);//判断是否存在职位名称
    List<Job> allJob();//全部职位
    List<Job> jobToEmp();//本职位的对应的人员
    boolean deleteJob(Job job);//删除职位  根据职位id
    Job getJobById(Job job);//根据职位id来查出职位
}
