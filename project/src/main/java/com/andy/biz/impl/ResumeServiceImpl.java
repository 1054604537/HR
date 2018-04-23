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
}
