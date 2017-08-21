package com.sanduo.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.sanduo.dao.UserDao;
import cn.sanduo.dao.UserDaoImpl;
import cn.sanduo.domain.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		SqlSessionFactory build = 
				new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		this.sqlSessionFactory = build;
	}
	/**
	 * 根据id查询用户
	 */
	@Test
	public void testFindUserById() {
		
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		User user = userDao.findUserById(4);
		System.out.println(user);
		
	}

}
