package com.andy.biz.impl;

import com.andy.biz.TrainService;
import com.andy.dao.TrainMapper;
import com.andy.model.Train;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/26.
 */
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;
    @Override
    public List<Train> allTrain() {
        return trainMapper.allTrain();
    }

    @Override
    public boolean saveTrian(Train train) {
        return trainMapper.saveTrian(train);
    }

    @Override
    public boolean deleteTrian(Train train) {
        return trainMapper.deleteTrian(train);
    }
}
