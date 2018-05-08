package com.andy.model;

import java.io.Serializable;

/**
 * Created by 10546 on 2018/5/3.
 */
//薪资表实体类
public class Sal implements Serializable {
    private int s_id;
    //private int s_basic_sal;//2200 +job+ (迟到)+(早退)+（加班）+（矿工）+（公司奖励）+（公司其他惩罚）
    private Job job;//职位的工资  员工所在的职位工资
    private Attence attence;//考勤的存在计算员工工资
    private RewAndPub rewAndPub;//奖惩的 费用计算
    private int s_scocial;//社保
    private Emp emp;//员工的ID  判断是那个哪个员工的

    public Sal() {
    }

    public Sal(int s_id, Job job, Attence attence, RewAndPub rewAndPub, int s_scocial, Emp emp) {
        this.s_id = s_id;

        this.job = job;
        this.attence = attence;
        this.rewAndPub = rewAndPub;
        this.s_scocial = s_scocial;
        this.emp = emp;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

//

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Attence getAttence() {
        return attence;
    }

    public void setAttence(Attence attence) {
        this.attence = attence;
    }

    public RewAndPub getRewAndPub() {
        return rewAndPub;
    }

    public void setRewAndPub(RewAndPub rewAndPub) {
        this.rewAndPub = rewAndPub;
    }

    public int getS_scocial() {
        return s_scocial;
    }

    public void setS_scocial(int s_scocial) {
        this.s_scocial = s_scocial;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Sal{" +
                "s_id=" + s_id +
                ", job=" + job +
                ", attence=" + attence +
                ", rewAndPub=" + rewAndPub +
                ", s_scocial=" + s_scocial +
                ", emp=" + emp +
                '}';
    }
}
