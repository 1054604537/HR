package com.andy.biz;

import com.andy.model.BossResume;

import java.util.List;

/**
 * Created by 10546 on 2018/4/22.
 */
public interface BossResumeService {
    boolean addBossResume(BossResume bossResume);
    List<BossResume> allBossResume();//全部投递人的简历

}
