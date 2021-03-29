package org.qianyan.prescriptionmanager.service;

import org.qianyan.prescriptionmanager.domain.Recipe;

import java.util.List;

/**
 * @author dyj123 2020/11/12
 * @Company Qianyan Studio
 * 中药配方 业务层接口
 */
public interface IRecipeService {

    /**
     * 查询 所有配方记录
     *
     * @return 配方列表
     * @throws Exception 异常
     */
    List<Recipe> findAll() throws Exception;

    /**
     * 条件查询 配方记录
     *
     * @param recipe_id 配方 ID
     * @return 配方记录
     * @throws Exception 异常
     */
    Recipe findById(Integer recipe_id) throws Exception;

    /**
     * 插入 配方记录
     *
     * @param recipe 配方
     * @return 记录 ID
     * @throws Exception 异常
     */
    int doInsert(Recipe recipe) throws Exception;

    /**
     * 删除 配方记录
     *
     * @param recipe_id 配方 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    int doDelete(Integer recipe_id) throws Exception;

}
