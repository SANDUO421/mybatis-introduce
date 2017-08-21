package com.sanduo.test;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.sanduo.domain.User;
import cn.sanduo.mapper.UserMapper;

/**
 * @Description:mapper生成
 * 
 * @author sanduo
 * 
 */
public class TestMapper {
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取代理创建代理对象
		UserMapper mapper= sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(4);
		System.out.println(user);
		
	}
	/**
	 * 根据name模糊查询用户
	 */
	@Test
	public void testFindUserByLikeName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取代理创建代理对象
		UserMapper mapper= sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.findUserByLikeName("sanduo");
		System.out.println(users);
		
	}

}
