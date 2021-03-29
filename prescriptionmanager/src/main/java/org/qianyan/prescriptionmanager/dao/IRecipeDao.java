package org.qianyan.prescriptionmanager.dao;

import org.apache.ibatis.annotations.*;

import org.qianyan.prescriptionmanager.domain.Recipe;

import java.util.List;

/**
 * @author dyj123 2020/11/12
 * @Company Qianyan Studio
 * 配方 持久层接口
 */
public interface IRecipeDao {

    /**
     * 查询所有配方记录
     *
     * @return 全部配方记录
     * @throws Exception 异常
     */
    @Select("SELECT * FROM recipe;")
    List<Recipe> findAll() throws Exception;

    /**
     * 使用配方 ID 查询配方记录
     *
     * @param recipe_id 配方 ID
     * @return 配方记录
     * @throws Exception 异常
     */
    @Select("SELECT * FROM recipe WHERE recipe_id = #{recipe_id};")
    Recipe findById(Integer recipe_id) throws Exception;

    /**
     * 保存配方记录
     *
     * @param recipe 配方
     * @return 配方 ID
     * @throws Exception 异常
     */
    @Insert("INSERT INTO recipe(recipe_name, recipe_ingredient) VALUES (#{recipe_name}, #{recipe_ingredient});")
    @Options(useGeneratedKeys = true, keyProperty = "recipe_id")
    int doInsert(Recipe recipe) throws Exception;

    /**
     * 删除配方记录
     *
     * @param recipe_id 配方 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    @Delete("DELETE FROM recipe WHERE recipe_id = #{recipe_id};")
    int doDelete(Integer recipe_id) throws Exception;

}
