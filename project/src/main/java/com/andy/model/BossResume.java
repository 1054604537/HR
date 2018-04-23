package com.andy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 10546 on 2018/4/22.
 */
public class BossResume implements Serializable {
    private int br_id;
    private Date br_date;
    private String br_job;
    private String br_uname;
    private String br_uphone;
    private String br_uemail;

    public BossResume() {
    }

    public BossResume(int br_id, Date br_date, String br_job, String br_uname, String br_uphone, String br_uemail) {
        this.br_id = br_id;
        this.br_date = br_date;
        this.br_job = br_job;
        this.br_uname = br_uname;
        this.br_uphone = br_uphone;
        this.br_uemail = br_uemail;
    }

    public int getBr_id() {
        return br_id;
    }

    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }

    public Date getBr_date() {
        return br_date;
    }

    public void setBr_date(Date br_date) {
        this.br_date = br_date;
    }

    public String getBr_job() {
        return br_job;
    }

    public void setBr_job(String br_job) {
        this.br_job = br_job;
    }

    public String getBr_uname() {
        return br_uname;
    }

    public void setBr_uname(String br_uname) {
        this.br_uname = br_uname;
    }

    public String getBr_uphone() {
        return br_uphone;
    }

    public void setBr_uphone(String br_uphone) {
        this.br_uphone = br_uphone;
    }

    public String getBr_uemail() {
        return br_uemail;
    }

    public void setBr_uemail(String br_uemail) {
        this.br_uemail = br_uemail;
    }

    @Override
    public String toString() {
        return "BossResume{" +
                "br_id=" + br_id +
                ", br_date=" + br_date +
                ", br_job='" + br_job + '\'' +
                ", br_uname='" + br_uname + '\'' +
                ", br_uphone='" + br_uphone + '\'' +
                ", br_uemail='" + br_uemail + '\'' +
                '}';
    }
}
