package com.andy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 10546 on 2018/4/27.
 */
public class RewAndPub implements Serializable {
    private int p_id;
    private String p_type;//类型
    private int p_number;//金额
    private Date p_date;
    private String p_descrption;
    private String e_id;//员工编号


    public RewAndPub() {
    }

    public RewAndPub(int p_id) {
        this.p_id = p_id;
    }

    public RewAndPub(int p_id, String p_type, int p_number, Date p_date, String p_descrption, String e_id) {
        this.p_id = p_id;
        this.p_type = p_type;
        this.p_number = p_number;
        this.p_date = p_date;
        this.p_descrption = p_descrption;
        this.e_id = e_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public int getP_number() {
        return p_number;
    }

    public void setP_number(int p_number) {
        this.p_number = p_number;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getP_descrption() {
        return p_descrption;
    }

    public void setP_descrption(String p_descrption) {
        this.p_descrption = p_descrption;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    @Override
    public String toString() {
        return "RewAndPub{" +
                "p_id=" + p_id +
                ", p_type='" + p_type + '\'' +
                ", p_number=" + p_number +
                ", p_date=" + p_date +
                ", p_descrption='" + p_descrption + '\'' +
                ", e_id=" + e_id +
                '}';
    }
}
