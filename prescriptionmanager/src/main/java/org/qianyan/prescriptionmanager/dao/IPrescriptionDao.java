package org.qianyan.prescriptionmanager.dao;

import org.apache.ibatis.annotations.*;

import org.qianyan.prescriptionmanager.domain.Prescription;
import org.qianyan.prescriptionmanager.domain.PrescriptionWithRecipeName;

import java.util.List;

/**
 * @author dyj123 2020/11/12
 * @Company Qianyan Studio
 * 处方笺 持久层接口
 */
public interface IPrescriptionDao {

    /**
     * 查询所有处方笺记录
     *
     * @return 全部处方笺记录
     * @throws Exception 异常
     */
    @Select("SELECT * FROM prescription;")
    List<Prescription> findAll() throws Exception;

    /**
     * 使用病人 ID 查询处方笺记录
     *
     * @param user_id 病人 ID
     * @return 此病人所有处方笺记录
     * @throws Exception 异常
     */
    @Select("SELECT * FROM prescription WHERE user_id = #{user_id};")
    List<Prescription> findByUserId(Integer user_id) throws Exception;

    /**
     * 使用配方 ID 查询处方笺记录
     *
     * @param recipe_id 配方 ID
     * @return 使用了此配方的所有处方笺记录
     * @throws Exception 异常
     */
    @Select("SELECT  * FROM prescription WHERE recipe_id = #{recipe_id};")
    List<Prescription> findByRecipeId(Integer recipe_id) throws Exception;

    /**
     * 使用病人 ID 查询处方笺记录和对应的配方名
     *
     * @param user_id 病人 ID
     * @return 带有对应配方名的处方笺记录
     * @throws Exception 异常
     */
    @Select("SELECT prescription.*, recipe.recipe_name FROM prescription LEFT JOIN recipe ON prescription.recipe_id = recipe.recipe_id WHERE prescription.user_id = #{user_id}")
    List<PrescriptionWithRecipeName> findWithRecipeNameByUserId(Integer user_id) throws Exception;

    /**
     * 保存处方笺记录
     *
     * @param prescription 处方笺记录
     * @return 处方笺 ID
     * @throws Exception 异常
     */
    @Insert("INSERT INTO prescription(user_id, recipe_id, prescription_date) VALUES (#{user_id}, #{recipe_id}, #{prescription_date});")
    @Options(useGeneratedKeys = true, keyProperty = "prescription_id")
    int doInsert(Prescription prescription) throws Exception;

    /**
     * 删除处方笺记录
     *
     * @param prescription_id 处方笺 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    @Delete("DELETE FROM prescription WHERE prescription_id = #{prescription_id};")
    int doDeleteByPreId(Integer prescription_id) throws Exception;

    /**
     * 删除某病人全部处方笺记录
     *
     * @param user_id 病人 ID
     * @return 删除的记录数量
     * @throws Exception 异常
     */
    @Delete("DELETE FROM prescription WHERE user_id = #{user_id};")
    int doDeleteByUserId(Integer user_id) throws Exception;

}
