package com.andy.model;

import java.io.Serializable;

/**
 * Created by 10546 on 2018/4/24.
 */
//正式员工表实体类
public class Emp implements Serializable{
    private int e_id;
    private String e_name;
    private String e_sex;
    private int e_phone;
    private String e_email;
    private int d_id;//部门id

    public Emp() {
    }

    public Emp(int e_id, String e_name, String e_sex, int e_phone, String e_email, int d_id) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_sex = e_sex;
        this.e_phone = e_phone;
        this.e_email = e_email;
        this.d_id = d_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public int getE_phone() {
        return e_phone;
    }

    public void setE_phone(int e_phone) {
        this.e_phone = e_phone;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_sex='" + e_sex + '\'' +
                ", e_phone=" + e_phone +
                ", e_email='" + e_email + '\'' +
                ", d_id=" + d_id +
                '}';
    }
}