package com.andy.biz;

import com.andy.model.Resume;

import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
public interface ResumeService {
    boolean addResume(Resume resume);
    List<Resume> allResume(int uid);
    boolean deleteResume(int rid);
    List<Resume> findResumeByUid(int uid);
    List<Resume> allResume2();//全部 用来判段是否存在数据
    Resume getResume(Resume resume);//查
    boolean  updateResume(Resume resume);//修改简历  根据 简历ID
    Resume getPhone(Resume resume);//查找手机号码时候在存在

}
