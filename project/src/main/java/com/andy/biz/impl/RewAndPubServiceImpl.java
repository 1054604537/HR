package com.andy.biz.impl;

import com.andy.biz.RewAndPubService;
import com.andy.dao.RewAndPubMapper;
import com.andy.model.RewAndPub;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/27.
 */
@Service
public class RewAndPubServiceImpl implements RewAndPubService {
    @Resource
    private RewAndPubMapper rewAndPubMapper;
    @Override
    public boolean addRewAndPub(RewAndPub rewAndPub) {
        rewAndPubMapper.addRewAndPub(rewAndPub);
        return false;
    }

    @Override
    public List<RewAndPub> allRewAndPub() {
        return rewAndPubMapper.allRewAndPub();
    }

    @Override
    public List<RewAndPub> empToRewAndPub(RewAndPub rewAndPub) {
        return rewAndPubMapper.empToRewAndPub(rewAndPub);
    }
}
