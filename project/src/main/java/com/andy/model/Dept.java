package com.andy.model;

import java.io.Serializable;

/**
 * Created by 10546 on 2018/4/24.
 */
public class Dept implements Serializable {
    private int d_id;
    private String d_name;

    public Dept() {
    }

    public Dept(int d_id, String d_name) {
        this.d_id = d_id;
        this.d_name = d_name;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                '}';
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }
}
