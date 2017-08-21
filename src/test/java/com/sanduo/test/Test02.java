package com.sanduo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.sanduo.domain.User;

/**
 * @Description:添加用户返回主键类型：简单主键和自定义主键
 * 
 * @author sanduo
 * 
 */
public class Test02 {
	/**
	 * 生成uuid的主键
	 * 
	 */
	
	/**
	 * 添加用户返回主键类型
	 */

	@Test
	public void AddUserTest() throws IOException{
		SqlSession sqlSession = openSession();
		User user = new User();
		user.setId(5);
		user.setName("李坤奇");
		user.setTelephone("123456789");
		int id = sqlSession.insert("test.InsertUser",user);
		System.out.println(id);
		sqlSession.commit();
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
