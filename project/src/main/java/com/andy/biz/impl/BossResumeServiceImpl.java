package com.andy.biz.impl;

import com.andy.biz.BossResumeService;
import com.andy.dao.BossResumeMapper;
import com.andy.model.BossResume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 10546 on 2018/4/22.
 */
@Service
public class BossResumeServiceImpl implements BossResumeService{
    @Resource
    private BossResumeMapper bossResumeMapper;
    @Override
    public boolean addBossResume(BossResume bossResume) {
        bossResumeMapper.addBossResume(bossResume);
        return true;
    }
}
