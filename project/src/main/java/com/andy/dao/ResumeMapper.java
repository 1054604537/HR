package com.andy.dao;

import com.andy.model.Resume;

import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
public interface ResumeMapper {
    boolean addResume(Resume resume);//用户添加简历
    List<Resume> allResume(int uid);
    boolean deleteResume(int rid);
}
