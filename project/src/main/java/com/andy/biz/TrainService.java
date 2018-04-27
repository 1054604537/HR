package com.andy.biz;

import com.andy.model.Train;

import java.util.List;

/**
 * Created by 10546 on 2018/4/26.
 */
public interface TrainService {
    List<Train> allTrain();//全部招聘信息
    boolean saveTrian(Train train);//添加培训消息
    boolean deleteTrian(Train train);//删除
    List<Train> getTrian(Train train);
}
