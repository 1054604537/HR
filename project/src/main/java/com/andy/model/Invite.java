package com.andy.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 10546 on 2018/4/23.
 */
//招聘邀请表实体类
public class Invite implements Serializable {
    private int i_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date i_date;
    private String i_job;
    private String i_site;
    private String i_description;
    private int i_uid;
    private String i_isno_accept;

    public Invite() {
    }

    public Invite(int i_id, Date i_date, String i_job, String i_site, String i_description) {
        this.i_id = i_id;
        this.i_date = i_date;
        this.i_job = i_job;
        this.i_site = i_site;
        this.i_description = i_description;
    }

    public Invite(int i_id, Date i_date, String i_job, String i_site, String i_description, int i_uid, String i_isno_accept) {
        this.i_id = i_id;
        this.i_date = i_date;
        this.i_job = i_job;
        this.i_site = i_site;
        this.i_description = i_description;
        this.i_uid = i_uid;
        this.i_isno_accept = i_isno_accept;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public Date getI_date() {
        return i_date;
    }

    public void setI_date(Date i_date) {
        this.i_date = i_date;
    }

    public String getI_job() {
        return i_job;
    }

    public void setI_job(String i_job) {
        this.i_job = i_job;
    }

    public String getI_site() {
        return i_site;
    }

    public void setI_site(String i_site) {
        this.i_site = i_site;
    }

    public String getI_description() {
        return i_description;
    }

    public void setI_description(String i_description) {
        this.i_description = i_description;
    }

    public int getI_uid() {
        return i_uid;
    }

    public void setI_uid(int i_uid) {
        this.i_uid = i_uid;
    }

    public String getI_isno_accept() {
        return i_isno_accept;
    }

    public void setI_isno_accept(String i_isno_accept) {
        this.i_isno_accept = i_isno_accept;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "i_id=" + i_id +
                ", i_date=" + i_date +
                ", i_job='" + i_job + '\'' +
                ", i_site='" + i_site + '\'' +
                ", i_description='" + i_description + '\'' +
                ", i_uid=" + i_uid +
                ", i_isno_accept='" + i_isno_accept + '\'' +
                '}';
    }
}
