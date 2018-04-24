package com.andy.biz.impl;

import com.andy.biz.AdminService;
import com.andy.dao.AdminMapper;
import com.andy.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public List<Admin> allAdmin() {
        return adminMapper.allAdmin();
    }
}
