package org.qianyan.prescriptionmanager.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.qianyan.prescriptionmanager.dao.IRecipeDao;
import org.qianyan.prescriptionmanager.domain.Recipe;
import org.qianyan.prescriptionmanager.service.IRecipeService;

import java.io.InputStream;
import java.util.List;

/**
 * @author dyj123 2020/11/12
 * @Company Qianyan Studio
 * 配方 业务层接口实现类
 */
public class RecipeServiceImpl implements IRecipeService {

    private final InputStream in;
    private final SqlSession session;
    private final IRecipeDao recipeDao;

    /**
     * 使用构造方法进行初始化操作
     * @throws Exception 异常
     */
    public RecipeServiceImpl() throws Exception {

        // 读取配置文件
        in = Resources.getResourceAsStream("config/mybatis.xml");

        // 使用配置文件信息创建 SqlSessionFactory 工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 使用创建的 SqlSessionFactory 工厂对象生产 SqlSession 对象
        // autoCommit: true 自动提交事务
        session = factory.openSession(true);

        // 使用 SqlSession 对象创建 UserDao 的代理对象
        recipeDao = session.getMapper(IRecipeDao.class);

    }

    /**
     * 释放资源
     * @throws Exception 异常
     */
    private void destroy() throws Exception {
        session.close();
        in.close();
    }

    /**
     * 查询 所有配方记录
     *
     * @return 配方列表
     * @throws Exception 异常
     */
    @Override
    public List<Recipe> findAll() throws Exception {
        List<Recipe> recipes = recipeDao.findAll();
        destroy();
        return recipes;
    }

    /**
     * 条件查询 配方记录
     *
     * @param recipe_id 配方 ID
     * @return 配方记录
     * @throws Exception 异常
     */
    @Override
    public Recipe findById(Integer recipe_id) throws Exception {
        Recipe recipe = recipeDao.findById(recipe_id);
        destroy();
        return recipe;
    }

    /**
     * 插入 配方记录
     *
     * @param recipe 配方
     * @return 记录 ID
     * @throws Exception 异常
     */
    @Override
    public int doInsert(Recipe recipe) throws Exception {
        int result = recipeDao.doInsert(recipe);
        destroy();
        return result;
    }

    /**
     * 删除 配方记录
     *
     * @param recipe_id 配方 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    @Override
    public int doDelete(Integer recipe_id) throws Exception {
        int result = recipeDao.doDelete(recipe_id);
        destroy();
        return result;
    }

}
