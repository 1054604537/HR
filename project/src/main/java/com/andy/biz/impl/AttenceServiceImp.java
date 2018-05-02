package com.andy.biz.impl;

import com.andy.biz.AttenceService;
import com.andy.dao.AttenceMapper;
import com.andy.model.Attence;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/30.
 */
@Service
public class AttenceServiceImp implements AttenceService {
    @Resource
    private AttenceMapper attenceMapper;
    @Override
    public boolean saveClockAttence(Attence attence) {
        attenceMapper.saveClockAttence(attence);
        return true;
    }

    @Override
    public boolean endAttence(Attence attence) {
        attenceMapper.endAttence(attence);
        return true;
    }

    @Override
    public List<Attence> allAttence(Attence attence) {
        return attenceMapper.allAttence(attence);
    }
}
