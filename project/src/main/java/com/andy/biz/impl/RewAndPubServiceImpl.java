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

    @Override
    public boolean deleteRew(RewAndPub rewAndPub) {
        return rewAndPubMapper.deleteRew(rewAndPub);
    }

    @Override
    public List<RewAndPub> empToSalByLate(RewAndPub rewAndPub) {
        return rewAndPubMapper.empToSalByLate(rewAndPub);
    }

    @Override
    public List<RewAndPub> empToSalBylate2(RewAndPub rewAndPub) {
        return rewAndPubMapper.empToSalBylate2(rewAndPub);
    }

    @Override
    public List<RewAndPub> empToSalBylate3(RewAndPub rewAndPub) {
        return rewAndPubMapper.empToSalBylate3(rewAndPub);
    }

    @Override
    public List<RewAndPub> empToSalBylate4(RewAndPub rewAndPub) {
        return rewAndPubMapper.empToSalBylate4(rewAndPub);
    }

    @Override
    public List<RewAndPub> findEmpSal() {
        return rewAndPubMapper.findEmpSal();
    }

    @Override
    public boolean updateReconsider(RewAndPub rewAndPub) {
        return rewAndPubMapper.updateReconsider(rewAndPub);
    }

    @Override
    public String findCount(String eid) {
        return rewAndPubMapper.findCount(eid);
    }

    @Override
    public List<RewAndPub> empToSalBylate5(RewAndPub rewAndPub) {
        return rewAndPubMapper.empToSalBylate5(rewAndPub);
    }
}
