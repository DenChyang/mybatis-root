package cn.jy.mybatis.test;

import cn.jy.mybatis.dao.UserDao;
import cn.jy.mybatis.dao.impl.UserDaoImpl;
import cn.jy.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
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

    private UserDao userDao ;

    @Before
    public void before() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //  创建sqlSessionFactory
        SqlSession sqlSession = factory.openSession();

        userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void test1() throws IOException {

        User user = userDao.findUserById(14l);
        System.out.println(user);
    }

    @Test
    public void test2() throws IOException {
        List<User> allUsers = userDao.findAllUsers();
        System.out.println(allUsers);
    }

    @Test
    public void test3() throws IOException {

        User user = new User();
        user.setUserName("lala4");
        user.setPassword("1234565");
        user.setName("拉拉4");
        user.setAge(12);
        user.setSex(1);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userDao.saveUser(user);
        System.out.println(user);
    }

    /**
     * 测试更新
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {

        User user = new User();
        user.setId(12L);
        user.setUserName("lala");
        user.setPassword("123456");
        user.setName("拉拉");
        user.setAge(14);
        user.setSex(2);
        user.setBirthday(new Date());
        user.setUpdated(new Date());
        userDao.updateUser(user);
        System.out.println(user);
    }


    @Test
    public void test5() throws IOException {

        userDao.deleteUser(14L);
    }
}
