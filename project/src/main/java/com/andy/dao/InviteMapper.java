package com.andy.dao;

import com.andy.model.Invite;

import java.util.List;

/**
 * Created by 10546 on 2018/4/23.
 */
public interface InviteMapper {
    boolean outInviteToUser(Invite invite);//给用户发邀请
    List<Invite> userMassageByUid(Invite invite);//uid查出用户的信息
    boolean isOrNoAccept(Invite invite);//用户是否接受面试，添加记录代表接收面试，，不接受部点击添加,
    List<Invite> allInvite();//已接受面试的员工及办入职信息
    boolean updateAlllo(Invite invite);//分配状态
}
