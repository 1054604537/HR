package com.andy.model;

/**
 * Created by 10546 on 2018/4/21.
 */
//招聘实体类
public class Recruit {
    private int re_id;
    private String j_name;//职位
    private int re_number;
    private String re_education;
    private double re_sal;
    private String re_descrption;

    public Recruit() {
    }

    public Recruit(int re_id, String j_name, int re_number, String re_education, double re_sal, String re_descrption) {
        this.re_id = re_id;
        this.j_name = j_name;
        this.re_number = re_number;
        this.re_education = re_education;
        this.re_sal = re_sal;
        this.re_descrption = re_descrption;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public int getRe_number() {
        return re_number;
    }

    public void setRe_number(int re_number) {
        this.re_number = re_number;
    }

    public String getRe_education() {
        return re_education;
    }

    public void setRe_education(String re_education) {
        this.re_education = re_education;
    }

    public double getRe_sal() {
        return re_sal;
    }

    public void setRe_sal(double re_sal) {
        this.re_sal = re_sal;
    }

    public String getRe_descrption() {
        return re_descrption;
    }

    public void setRe_descrption(String re_descrption) {
        this.re_descrption = re_descrption;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "re_id=" + re_id +
                ", j_name='" + j_name + '\'' +
                ", re_number=" + re_number +
                ", re_education='" + re_education + '\'' +
                ", re_sal=" + re_sal +
                ", re_descrption='" + re_descrption + '\'' +
                '}';
    }
}
