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
}
