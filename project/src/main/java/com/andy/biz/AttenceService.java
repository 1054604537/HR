package com.andy.biz;

import com.andy.model.Attence;

import java.util.List;

/**
 * Created by 10546 on 2018/4/30.
 */
public interface AttenceService {
    boolean saveClockAttence(Attence attence);//上班打卡
    boolean endAttence(Attence attence);//下班打卡
    List<Attence> allAttence(Attence attence);//根据员工id 查看个人的考勤记录
}
