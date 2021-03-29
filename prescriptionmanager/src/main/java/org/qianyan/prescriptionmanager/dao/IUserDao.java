package org.qianyan.prescriptionmanager.dao;

import org.apache.ibatis.annotations.*;

import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.domain.UserVo;

import java.util.List;

/**
 * @author dyj123 2020/11/11
 * @Company Qianyan Studio
 * 病人 持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有病人记录
     *
     * @return 全部病人记录
     * @throws Exception 异常
     */
    @Select("SELECT * FROM user;")
    List<User> findAll() throws Exception;

    /**
     * 使用值对象多条件查询病人记录
     *
     * @param vo 条件 值对象
     * @return 病人记录
     * @throws Exception 异常
     */
    @Select("SELECT * FROM user WHERE user_name = #{user.user_name} AND user_tel = #{user.user_tel};")
    User findByVo(UserVo vo) throws Exception;

    /**
     * 保存病人记录
     *
     * @param user 病人记录
     * @return 记录 ID
     * @throws Exception 异常
     */
    @Insert("INSERT INTO user(user_name, user_sex, user_age, user_tel) VALUES (#{user_name}, #{user_sex}, #{user_age}, #{user_tel});")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    int doInsert(User user) throws Exception;

    /**
     * 修改病人记录
     *
     * @param user 病人记录
     * @return 修改是否成功
     * @throws Exception 异常
     */
    @Update("UPDATE user SET user_name = #{user_name}, user_sex = #{user_sex}, user_age = #{user_age}, user_tel = #{user_tel} WHERE user_id = #{user_id};")
    int doUpdate(User user) throws Exception;

    /**
     * 删除病人记录
     *
     * @param user_id 病人 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    @Delete("DELETE FROM user WHERE user_id = #{user_id}")
    int doDelete(Integer user_id) throws Exception;

}
