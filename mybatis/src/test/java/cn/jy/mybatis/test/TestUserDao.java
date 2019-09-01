package cn.jy.mybatis.test;

import cn.jy.mybatis.dao.UserDao;
import cn.jy.mybatis.dao.impl.UserDaoImpl;
import cn.jy.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author DengQiang.Wu
 * @create 2019-09-01 18:37
 */
public class TestUserDao {

    @Test
    public void test1() throws IOException {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //  创建sqlSessionFactory
        SqlSession sqlSession = factory.openSession();

        UserDao userDao = new UserDaoImpl(sqlSession);
        User user = userDao.findUserById(2L);
        System.out.println(user);
    }

    @Test
    public void test2() throws IOException {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //  创建sqlSessionFactory
        SqlSession sqlSession = factory.openSession();

        UserDao userDao = new UserDaoImpl(sqlSession);
        List<User> allUsers = userDao.findAllUsers();
        System.out.println(allUsers);
    }

    @Test
    public void test3() throws IOException {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //  创建sqlSessionFactory
        SqlSession sqlSession = factory.openSession();

        UserDao userDao = new UserDaoImpl(sqlSession);
        User user = new User();
        user.setUserName("lala1");
        user.setPassword("1234565");
        user.setName("拉拉2");
        user.setAge(12);
        user.setSex(1);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userDao.saveUser(user);
        System.out.println(user);
    }
}