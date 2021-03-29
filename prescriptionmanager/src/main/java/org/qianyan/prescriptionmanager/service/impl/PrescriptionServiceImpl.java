package org.qianyan.prescriptionmanager.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.qianyan.prescriptionmanager.dao.IPrescriptionDao;
import org.qianyan.prescriptionmanager.domain.Prescription;
import org.qianyan.prescriptionmanager.domain.PrescriptionWithRecipeName;
import org.qianyan.prescriptionmanager.service.IPrescriptionService;

import java.io.InputStream;
import java.util.List;

/**
 * @author dyj123 2020/11/12
 * @Company Qianyan Studio
 */
public class PrescriptionServiceImpl implements IPrescriptionService {

    private final InputStream in;
    private final SqlSession session;
    private final IPrescriptionDao prescriptionDao;

    /**
     * 使用构造方法进行初始化操作
     *
     * @throws Exception 异常
     */
    public PrescriptionServiceImpl() throws Exception {

        // 读取配置文件
        in = Resources.getResourceAsStream("config/mybatis.xml");

        // 使用配置文件信息创建 SqlSessionFactory 工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 使用创建的 SqlSessionFactory 工厂对象生产 SqlSession 对象
        // autoCommit: true 自动提交事务
        session = factory.openSession(true);

        // 使用 SqlSession 对象创建 UserDao 的代理对象
        prescriptionDao = session.getMapper(IPrescriptionDao.class);

    }

    /**
     * 释放资源
     *
     * @throws Exception 异常
     */
    private void destroy() throws Exception {
        session.close();
        in.close();
    }

    /**
     * 查询所有处方笺记录
     *
     * @return 全部处方笺记录
     * @throws Exception 异常
     */
    @Override
    public List<Prescription> findAll() throws Exception {
        List<Prescription> prescriptions = prescriptionDao.findAll();
        destroy();
        return prescriptions;
    }

    /**
     * 使用病人 ID 查询处方笺记录
     *
     * @param user_id 病人 ID
     * @return 此病人的全部处方笺记录
     * @throws Exception 异常
     */
    @Override
    public List<Prescription> findByUserId(Integer user_id) throws Exception {
        List<Prescription> prescriptions = prescriptionDao.findByUserId(user_id);
        destroy();
        return prescriptions;
    }

    /**
     * 使用配方 ID 查询处方笺记录
     *
     * @param recipe_id 配方 ID
     * @return 使用了此配方的所有处方笺记录
     * @throws Exception 异常
     */
    @Override
    public List<Prescription> findByRecipeId(Integer recipe_id) throws Exception {
        List<Prescription> prescriptions = prescriptionDao.findByRecipeId(recipe_id);
        destroy();
        return  prescriptions;
    }

    /**
     * 使用病人 ID 查询处方笺记录和对应的配方名
     *
     * @param user_id 病人 ID
     * @return 带有对应配方名的处方笺记录
     * @throws Exception 异常
     */
    public List<PrescriptionWithRecipeName> findWithRecipeNameByUserId(Integer user_id) throws Exception {
        List<PrescriptionWithRecipeName> prescriptionsWithRecipeName = prescriptionDao.findWithRecipeNameByUserId(user_id);
        destroy();
        return prescriptionsWithRecipeName;
    }

    /**
     * 保存处方笺记录
     *
     * @param prescription 处方笺记录
     * @return 记录 ID
     * @throws Exception 异常
     */
    @Override
    public int doInsert(Prescription prescription) throws Exception {
        int result = prescriptionDao.doInsert(prescription);
        destroy();
        return result;
    }

    /**
     * 使用处方笺 ID 删除处方笺记录
     *
     * @param prescription_id 处方笺 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    @Override
    public int doDeleteByPreId(Integer prescription_id) throws Exception {
        int result = prescriptionDao.doDeleteByPreId(prescription_id);
        destroy();
        return result;
    }

    /**
     * 删除某病人的全部处方笺记录
     *
     * @param user_id 病人 ID
     * @return 删除的记录数量
     * @throws Exception 异常
     */
    @Override
    public int doDeleteByUserId(Integer user_id) throws Exception {
        int result = prescriptionDao.doDeleteByUserId(user_id);
        destroy();
        return result;
    }



}
