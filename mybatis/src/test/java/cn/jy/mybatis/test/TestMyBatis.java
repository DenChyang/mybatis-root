package cn.jy.mybatis.test;

import cn.jy.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author DengQiang.Wu
 * @create 2019-08-24 14:53
 */
public class TestMyBatis {

    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in,"test");
            //  创建sqlSessionFactory
            sqlSession = factory.openSession();
            // sqlSession
            User user = sqlSession.selectOne("UserMapper.queryUserById", 1L);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void test2() {
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            //  创建sqlSessionFactory
            sqlSession = factory.openSession();
            // sqlSession
            User user = sqlSession.selectOne("UserMapper.queryUserById", 1L);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void test3() {
        SqlSession sqlSession = null;
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            //  创建sqlSessionFactory
            sqlSession = factory.openSession();
            // sqlSession
            // 测试系统内置别名string(java.lang.String)
            String name = sqlSession.selectOne("UserMapper.queryNameById", 1L);
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
