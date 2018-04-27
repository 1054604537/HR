package com.andy.dao;

import com.andy.model.RewAndPub;

import java.util.List;

/**
 * Created by 10546 on 2018/4/27.
 */
public interface RewAndPubMapper {
    boolean addRewAndPub(RewAndPub rewAndPub);//管理员对员共的奖惩操作
    List<RewAndPub> allRewAndPub();//全部
    List<RewAndPub> empToRewAndPub(RewAndPub rewAndPub);//员工对应的奖惩
}
