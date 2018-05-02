package com.andy.model;

import java.util.Date;

/**
 * Created by 10546 on 2018/4/30.
 */
//员工打卡实体类
public class Attence {
    private int a_id;
    private Date a_clock_in;//上班打卡
    private Date a_end_in;//下班打卡
    private String a_type;//考勤类型
    private int e_eid;//员工id

    public Attence() {
    }

    public Attence(int a_id, Date a_clock_in, Date a_end_in, String a_type, int e_eid) {
        this.a_id = a_id;
        this.a_clock_in = a_clock_in;
        this.a_end_in = a_end_in;
        this.a_type = a_type;
        this.e_eid = e_eid;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public Date getA_clock_in() {
        return a_clock_in;
    }

    public void setA_clock_in(Date a_clock_in) {
        this.a_clock_in = a_clock_in;
    }

    public Date getA_end_in() {
        return a_end_in;
    }

    public void setA_end_in(Date a_end_in) {
        this.a_end_in = a_end_in;
    }

    public String getA_type() {
        return a_type;
    }

    public void setA_type(String a_type) {
        this.a_type = a_type;
    }

    public int getE_eid() {
        return e_eid;
    }

    public void setE_eid(int e_eid) {
        this.e_eid = e_eid;
    }

    @Override
    public String toString() {
        return "Attence{" +
                "a_id=" + a_id +
                ", a_clock_in=" + a_clock_in +
                ", a_end_in=" + a_end_in +
                ", a_type='" + a_type + '\'' +
                ", e_eid=" + e_eid +
                '}';
    }
}
