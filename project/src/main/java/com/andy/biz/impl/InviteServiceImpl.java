package com.andy.biz.impl;

import com.andy.biz.InviteService;
import com.andy.dao.InviteMapper;
import com.andy.model.Invite;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 10546 on 2018/4/24.
 */
@Service
public class InviteServiceImpl implements InviteService {
    @Resource
    private InviteMapper inviteMapper;
    @Override
    public List<Invite> userMassageByUid(Invite invite) {
        List<Invite> list=inviteMapper.userMassageByUid(invite);
        if (list.size()!=0){
            return list;
        }
        return null;
    }

    @Override
    public boolean isOrNoAccept(Invite invite) {
        inviteMapper.isOrNoAccept(invite);
        return true;
    }

    @Override
    public List<Invite> allInvite() {
        return inviteMapper.allInvite();
    }

    @Override
    public boolean updateAlllo(Invite invite) {
        return inviteMapper.updateAlllo(invite);
    }

    @Override
    public boolean outInviteToUser(Invite invite) {
        return inviteMapper.outInviteToUser(invite);
    }
}
