package org.qianyan.prescriptionmanager.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.qianyan.prescriptionmanager.dao.IUserDao;
import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.domain.UserVo;
import org.qianyan.prescriptionmanager.service.IUserService;

import java.io.InputStream;
import java.util.List;

/**
 * @author dyj123 2020/11/11
 * @Company Qianyan Studio
 * 病人 业务层接口实现类
 */
public class UserServiceImpl implements IUserService {

    private final InputStream in;
    private final SqlSession session;
    private final IUserDao userDao;

    /**
     * 使用构造方法进行初始化操作
     * @throws Exception 异常
     */
    public UserServiceImpl() throws Exception {

        // 读取配置文件
        in = Resources.getResourceAsStream("config/mybatis.xml");

        // 使用配置文件信息创建 SqlSessionFactory 工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 使用创建的 SqlSessionFactory 工厂对象生产 SqlSession 对象
        // autoCommit: true 自动提交事务
        session = factory.openSession(true);

        // 使用 SqlSession 对象创建 UserDao 的代理对象
        userDao = session.getMapper(IUserDao.class);

    }

    /**
     * 释放资源
     * @throws Exception 异常
     */
    private void destroy() throws Exception {
        in.close();
        session.close();
    }

    /**
     * 查询所有病人记录
     *
     * @return 病人列表
     * @throws Exception 异常
     */
    @Override
    public List<User> findAll() throws Exception {
        List<User> users = userDao.findAll();
        destroy();
        return users;
    }

    /**
     * 使用值对象多条件查询病人记录
     *
     * @param vo 条件 值对象
     * @return 病人记录
     * @throws Exception 异常
     */
    @Override
    public User findByVo(UserVo vo) throws Exception {
        User user = userDao.findByVo(vo);
        destroy();
        return user;
    }

    /**
     * 保存病人记录
     *
     * @param user 病人记录
     * @return 记录 ID
     * @throws Exception 异常
     */
    @Override
    public int doInsert(User user) throws Exception {
        int result = userDao.doInsert(user);
        destroy();
        return result;
    }

    /**
     * 修改病人记录
     *
     * @param user 病人记录
     * @return 修改是否成功
     * @throws Exception 异常
     */
    @Override
    public int doUpdate(User user) throws Exception {
        int result = userDao.doUpdate(user);
        destroy();
        return result;
    }

    /**
     * 删除病人记录
     *
     * @param user_id 病人 ID
     * @return 删除是否成功
     * @throws Exception 异常
     */
    @Override
    public int doDelete(Integer user_id) throws Exception {
        int result = userDao.doDelete(user_id);
        destroy();
        return result;
    }
}
