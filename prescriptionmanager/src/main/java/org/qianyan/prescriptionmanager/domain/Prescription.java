package org.qianyan.prescriptionmanager.domain;

import java.io.Serializable;

/**
 * @author dyj123 2020/11/11
 * @Company Qianyan Studio
 * 处方笺 实体类
 */
public class Prescription implements Serializable {

    private Integer prescription_id;
    private Integer user_id;
    private Integer recipe_id;
    private String prescription_date;

    public Integer getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(Integer prescription_id) {
        this.prescription_id = prescription_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getPrescription_date() {
        return prescription_date;
    }

    public void setPrescription_date(String prescription_date) {
        this.prescription_date = prescription_date;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescription_id=" + prescription_id +
                ", user_id=" + user_id +
                ", recipe_id=" + recipe_id +
                ", prescrption_date='" + prescription_date + '\'' +
                '}';
    }

}
