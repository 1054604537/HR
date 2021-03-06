package com.andy.biz.impl;

import com.andy.biz.ResumeService;
import com.andy.dao.ResumeMapper;
import com.andy.model.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/20.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;
    @Override
    public boolean addResume(Resume resume) {
        resumeMapper.addResume(resume);
        return true;
    }

    @Override
    public List<Resume> allResume(int uid) {
        List<Resume>list=resumeMapper.allResume(uid);
        if (list.size()!=0){
            return list;
        }
        return null;
    }

    @Override
    public boolean deleteResume(int rid) {
        return resumeMapper.deleteResume(rid);
    }

    @Override
    public List<Resume> findResumeByUid(int uid) {
        return resumeMapper.findResumeByUid(uid);
    }

    @Override
    public List<Resume> allResume2() {
        return resumeMapper.allResume2();
    }

    @Override
    public Resume getResume(Resume resume) {
        return resumeMapper.getResume(resume);
    }

    @Override
    public Resume getPhone(Resume resume) {
        return resumeMapper.getPhone(resume);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return resumeMapper.updateResume(resume);
    }
}
