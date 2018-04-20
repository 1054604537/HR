package com.andy.model;

import java.io.Serializable;

/**
 * Created by 10546 on 2018/4/20.
 */
public class User implements Serializable {
    private int u_id;
    private String u_name;
    private String u_pass;
    private String u_email;


    public User() {
    }

    public User(int u_id, String u_name, String u_pass, String u_email) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pass = u_pass;
        this.u_email = u_email;
    }

    public User(String u_name, String u_pass) {
        this.u_name = u_name;
        this.u_pass = u_pass;
    }

    public User(String u_name, String u_pass, String u_email) {
        this.u_name = u_name;
        this.u_pass = u_pass;
        this.u_email = u_email;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pass='" + u_pass + '\'' +
                ", u_email='" + u_email + '\'' +
                '}';
    }
}
