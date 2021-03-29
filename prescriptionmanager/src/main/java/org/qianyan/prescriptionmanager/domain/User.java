package org.qianyan.prescriptionmanager.domain;

import java.io.Serializable;

/**
 * @author dyj123 2020/11/11
 * @Company Qianyan Studio
 * 病人 实体类
 */
public class User implements Serializable {

    private Integer user_id;
    private String user_name;
    private String user_sex;
    private Integer user_age;
    private String user_tel;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_age='" + user_age + '\'' +
                ", user_tel='" + user_tel + '\'' +
                '}';
    }

}
