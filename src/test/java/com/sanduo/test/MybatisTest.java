package com.sanduo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.sanduo.domain.User;

/**
 * 测试类
 * @author sanduo
 *
 */
public class MybatisTest {
	/**
	 * 修改用户
	 */
	@Test
	public void updateByIdTest() throws IOException{
		SqlSession sqlSession = openSession();
		User user = new User();
		user.setId(4);
		user.setName("sanduo");
		user.setTelephone("976543233");
		sqlSession.update("test.updateById",user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	/**
	 * 删除用户
	 */
	@Test
	public void deleteNameByIdTest() throws IOException{
		SqlSession sqlSession = openSession();
		sqlSession.delete("test.deleteNameById",5);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 添加用户
	 */
	@Test
	public void InsertUserTest() throws IOException{
		SqlSession sqlSession = openSession();
		User user = new User();
		user.setId(3);
		user.setName("sanduo");
		user.setTelephone("123456789");
		sqlSession.insert("test.InsertUser",user);
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 模糊查询
	 */
	@Test
	public void findUserLikeNameTest() throws IOException{
		SqlSession sqlSession = openSession();
		//sqlSession.commit(false);
		/*List<User> users = sqlSession.selectList("test.findUserByLikeName","马");*/
		List<User> users = sqlSession.selectList("test.findUserByLikeName","%马%");
		System.out.println(users);
		sqlSession.close();
	}
	
	/**
	 * 根据id查询
	 * @throws IOException
	 */

	@Test
	public void findUserByIdTest() throws IOException{
		SqlSession sqlSession = openSession();
	
		User user = sqlSession.selectOne("test.findUserById",1);
		System.out.println(user);
		sqlSession.close();
		
	}

	/**
	 * 根据名字查询
	 * @throws IOException
	 */
	@Test
	public void findUserByNameTest() throws IOException{
		SqlSession sqlSession = openSession();
		
		User user = sqlSession.selectOne("test.findUserByName","姚元宝");
		System.out.println(user);
		sqlSession.close();
		
	}

	private SqlSession openSession() throws IOException {
		String source ="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(source);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
