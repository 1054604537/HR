package com.andy.biz;

import com.andy.model.Attence;

import java.util.List;

/**
 * Created by 10546 on 2018/4/30.
 */
public interface AttenceService {
    boolean saveClockAttence(Attence attence);//上班打卡
    boolean addEndAttence(Attence attence);//下班打卡
    List<Attence> allAttence(Attence attence);//根据员工id 查看个人的考勤记录
    Attence getDate(Attence attence);//查找有没有今天的时间  没有做添加 有就做更改
    Attence getDate2(Attence attence);//查找有没有今天的上班打卡时间  没有做添加 有就做更改

}
