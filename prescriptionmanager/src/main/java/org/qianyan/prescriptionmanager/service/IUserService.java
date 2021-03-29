package org.qianyan.prescriptionmanager.service;

import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.domain.UserVo;

import java.util.List;

/**
 * @author dyj123 2020/11/11
 * @Company Qianyan Studio
 * 病人 业务层接口
 */
public interface IUserService {

    /**
     * 查询所有病人记录
     *
     * @return 病人列表
     * @throws Exception 异常
     */
    List<User> findAll() throws Exception;

    /**
     * 使用值对象多条件查询病人记录
     *
     * @param vo 条件 值对象
     * @return 病人记录
     * @throws Exception 异常
     */
    User findByVo(UserVo vo) throws Exception;

    /**
     * 保存病人记录
     *
     * @param user 病人记录
     * @return 记录 ID
     * @throws Exception 异常
     */
    int doInsert(User user) throws Exception;

    /**
     * 修改病人记录
     *
     * @param user 病人记录
     * @return 修改是否成功
     * @throws Exception 异常
     */
    int doUpdate(User user) throws Exception;

    /**
     * 删除病人记录
     *
     * @param user_id 病人 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    int doDelete(Integer user_id) throws Exception;

}
