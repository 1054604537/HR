package com.andy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 10546 on 2018/4/21.
 */
//职位实体类
public class Job implements Serializable{
    private int j_id;
    private String j_name;
    private Date j_date;
    private Double j_jsal;
    private int d_did;
    private List<Emp> emps=new ArrayList<>();

    public Job() {
    }

    public Job(int j_id, String j_name, Date j_date, Double j_jsal, int d_did) {
        this.j_id = j_id;
        this.j_name = j_name;
        this.j_date = j_date;
        this.j_jsal = j_jsal;
        this.d_did = d_did;
    }

    public Job(int j_id, String j_name, Date j_date, Double j_jsal, int d_did, List<Emp> emps) {
        this.j_id = j_id;
        this.j_name = j_name;
        this.j_date = j_date;
        this.j_jsal = j_jsal;
        this.d_did = d_did;
        this.emps = emps;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public Date getJ_date() {
        return j_date;
    }

    public void setJ_date(Date j_date) {
        this.j_date = j_date;
    }

    public Double getJ_jsal() {
        return j_jsal;
    }

    public void setJ_jsal(Double j_jsal) {
        this.j_jsal = j_jsal;
    }

    public int getD_did() {
        return d_did;
    }

    public void setD_did(int d_did) {
        this.d_did = d_did;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", j_name='" + j_name + '\'' +
                ", j_date=" + j_date +
                ", j_jsal=" + j_jsal +
                ", d_did=" + d_did +
                ", emps=" + emps +
                '}';
    }
}
