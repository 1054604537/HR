package com.andy.dao;

import com.andy.model.Recruit;

import java.util.List;

/**
 * Created by 10546 on 2018/4/22.
 */
public interface RecruitMapper {
    List<Recruit> allRecruit();//查看所有发布消息
    boolean addRecruit(Recruit recruit);//添加发布简历
    boolean deleteRecruit(int rid);//根据顺序reid

}
