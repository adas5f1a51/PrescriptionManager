package org.qianyan.prescriptionmanager.domain;

import java.io.Serializable;

/**
 * @author dyj123 2020/11/11
 * @Company Qianyan Studio
 * 配方 实体类
 */
public class Recipe implements Serializable {

    private Integer recipe_id;
    private String recipe_name;
    private String recipe_ingredient;

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

    public String getRecipe_ingredient() {
        return recipe_ingredient;
    }

    public void setRecipe_ingredient(String recipe_ingredient) {
        this.recipe_ingredient = recipe_ingredient;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", recipe_name='" + recipe_name + '\'' +
                ", recipe_ingredient=" + recipe_ingredient +
                '}';
    }

}
