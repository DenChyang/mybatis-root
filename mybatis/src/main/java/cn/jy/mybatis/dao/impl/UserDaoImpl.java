package cn.jy.mybatis.dao.impl;

import cn.jy.mybatis.dao.UserDao;
import cn.jy.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author DengQiang.Wu
 * @create 2019-09-01 18:31
 */
public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User findUserById(Long id) {
        User user = this.sqlSession.selectOne("UserDaoMapper.findUserById", id);
        // long类型用string接受也没有问题？
        //User user = this.sqlSession.selectOne("UserDaoMapper.findUserById", "1");
        this.sqlSession.close();
        return user;
    }

    @Override
    public List<User> findAllUsers() {

        List<User> userList = this.sqlSession.selectList("UserDaoMapper.findAllUsers");
        this.sqlSession.close();
        return userList;
    }

    @Override
    public void saveUser(User user) {
        this.sqlSession.insert("UserDaoMapper.saveUser",user);
        // 提交事务
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("UserDaoMapper.updateUser", user);

        // 提交事务
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @Override
    public void deleteUser(Long id) {
        this.sqlSession.delete("UserDaoMapper.deleteUser", id);
        this.sqlSession.commit();
        this.sqlSession.close();
    }
}
