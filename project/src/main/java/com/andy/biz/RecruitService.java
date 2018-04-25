package com.andy.biz;

import com.andy.model.Recruit;

import java.util.List;

/**
 * Created by 10546 on 2018/4/22.
 */
public interface RecruitService {
    List<Recruit> allRecruit();
    boolean addRecruit(Recruit recruit);//添加发布简历
    boolean deleteRecruit(int rid);//根据顺序reid
}
