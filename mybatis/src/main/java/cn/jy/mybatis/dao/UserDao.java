package cn.jy.mybatis.dao;

import cn.jy.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author DengQiang.Wu
 * @create 2019-09-01 18:18
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
     *
     */
    public void saveUser(User user);

}
