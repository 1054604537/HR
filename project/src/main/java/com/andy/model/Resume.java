package com.andy.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 10546 on 2018/4/20.
 */
//简历实体类
public class Resume implements Serializable{
    private int r_id;
    private String r_name;
    private String r_sex;
    private String r_age;
    private String r_phone;
    private String r_email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_birthdate;
    private String r_education;//学历
    private String r_description;
    private int u_id;//对用用户的主键id

    public Resume() {
    }

    public Resume(int r_id, String r_name, String r_sex, String r_age, String r_phone, String r_email, Date r_birthdate, String r_education, String r_description, int u_id) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_sex = r_sex;
        this.r_age = r_age;
        this.r_phone = r_phone;
        this.r_email = r_email;
        this.r_birthdate = r_birthdate;
        this.r_education = r_education;
        this.r_description = r_description;
        this.u_id = u_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_age() {
        return r_age;
    }

    public void setR_age(String r_age) {
        this.r_age = r_age;
    }

    public String getR_phone() {
        return r_phone;
    }

    public void setR_phone(String r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public Date getR_birthdate() {
        return r_birthdate;
    }

    public void setR_birthdate(Date r_birthdate) {
        this.r_birthdate = r_birthdate;
    }

    public String getR_education() {
        return r_education;
    }

    public void setR_education(String r_education) {
        this.r_education = r_education;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_sex='" + r_sex + '\'' +
                ", r_age='" + r_age + '\'' +
                ", r_phone='" + r_phone + '\'' +
                ", r_email='" + r_email + '\'' +
                ", r_birthdate=" + r_birthdate +
                ", r_education='" + r_education + '\'' +
                ", r_description='" + r_description + '\'' +
                ", u_id=" + u_id +
                '}';
    }
}
