package com.andy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 10546 on 2018/4/26.
 */
//培训的实体类
public class Train implements Serializable {
    private int t_id;
    private String t_theme;
    private String t_content;
    private Date t_startdate;
    private Date t_enddate;
    private String t_site;
    private int d_id;

    public Train() {
    }

    public Train(int t_id, String t_theme, String t_content, Date t_startdate, Date t_enddate, String t_site, int d_id) {
        this.t_id = t_id;
        this.t_theme = t_theme;
        this.t_content = t_content;
        this.t_startdate = t_startdate;
        this.t_enddate = t_enddate;
        this.t_site = t_site;
        this.d_id = d_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_theme() {
        return t_theme;
    }

    public void setT_theme(String t_theme) {
        this.t_theme = t_theme;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public Date getT_startdate() {
        return t_startdate;
    }

    public void setT_startdate(Date t_startdate) {
        this.t_startdate = t_startdate;
    }

    public Date getT_enddate() {
        return t_enddate;
    }

    public void setT_enddate(Date t_enddate) {
        this.t_enddate = t_enddate;
    }

    public String getT_site() {
        return t_site;
    }

    public void setT_site(String t_site) {
        this.t_site = t_site;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "Train{" +
                "t_id=" + t_id +
                ", t_theme='" + t_theme + '\'' +
                ", t_content='" + t_content + '\'' +
                ", t_startdate=" + t_startdate +
                ", t_enddate=" + t_enddate +
                ", t_site='" + t_site + '\'' +
                ", d_id=" + d_id +
                '}';
    }
}
