package org.qianyan.prescriptionmanager.domain;

import java.io.Serializable;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 带有配方名的处方笺 实体类
 */
public class PrescriptionWithRecipeName extends Prescription implements Serializable {

    private Integer prescription_id;
    private Integer user_id;
    private Integer recipe_id;
    private String recipe_name;
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

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getPrescription_date() {
        return prescription_date;
    }

    public void setPrescription_date(String prescription_date) {
        this.prescription_date = prescription_date;
    }

    @Override
    public String toString() {
        return "PrescriptionWithRecipeName{" +
                "prescription_id=" + prescription_id +
                ", user_id=" + user_id +
                ", recipe_id=" + recipe_id +
                ", recipe_name='" + recipe_name + '\'' +
                ", prescription_date='" + prescription_date + '\'' +
                '}';
    }

}
