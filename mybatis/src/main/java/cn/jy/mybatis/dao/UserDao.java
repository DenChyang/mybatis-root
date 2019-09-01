package cn.jy.mybatis.dao;

import cn.jy.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author DengQiang.Wu
 * @date  2019-09-01 18:18
 */
public interface UserDao {

    /**
     *
     * @param id
     * @return
     */
    public User findUserById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllUsers();

    /**************************/
    /**
     * 新增用户
     */
    public void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户
     */
    public void deleteUser(Long id);

    /**
     * 用户登录--查询操作
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password);

}
