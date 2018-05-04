package com.andy.biz;

import com.andy.model.RewAndPub;

import java.util.List;

/**
 * Created by 10546 on 2018/4/27.
 */
public interface RewAndPubService {
    boolean addRewAndPub(RewAndPub rewAndPub);//管理员对员共的奖惩操作
    List<RewAndPub> allRewAndPub();//全部
    List<RewAndPub> empToRewAndPub(RewAndPub rewAndPub);//员工对应的奖惩
    boolean deleteRew(RewAndPub rewAndPub);//删除记录
    List<RewAndPub> empToSalByLate(RewAndPub rewAndPub);//员工迟到记录
    List<RewAndPub> empToSalBylate2(RewAndPub rewAndPub);//员工早退记录
    List<RewAndPub> empToSalBylate3(RewAndPub rewAndPub);//员工矿工记录
    List<RewAndPub> empToSalBylate4(RewAndPub rewAndPub);//员工奖励记录
    List<RewAndPub> empToSalBylate5(RewAndPub rewAndPub);//员工惩罚记录
}
