package com.andy.biz.impl;

import com.andy.biz.RecruitService;
import com.andy.dao.RecruitMapper;
import com.andy.model.Recruit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/22.
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;
    @Override
    public List<Recruit> allRecruit() {
       List<Recruit> list= recruitMapper.allRecruit();
       if (list.size()!=0){
           return list;
       }
        return null;
    }

    @Override
    public boolean addRecruit(Recruit recruit) {
        recruitMapper.addRecruit(recruit);
        return true;
    }

    @Override
    public boolean deleteRecruit(int rid) {
        recruitMapper.deleteRecruit(rid);
        return false;
    }
}
