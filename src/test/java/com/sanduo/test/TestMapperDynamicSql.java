package com.sanduo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.sanduo.domain.QueryUserPo;
import cn.sanduo.domain.User;
import cn.sanduo.mapper.UserMapper;
import cn.sanduo.mapper.UserMapperDynamicSql;
import cn.sanduo.mapper.UserMapperInner;

/**
 * 传递pojo包装类实现mapper多条件查询
 * 
 * @author sanduo
 * 
 */
public class TestMapperDynamicSql {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		SqlSessionFactory build = 
				new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		this.sqlSessionFactory = build;
	}
	/**
	 * 根据name模糊查询用户------pojo
	 */
	@Test
	public void testFindUserByLikeName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取代理创建代理对象
		UserMapperDynamicSql mapper= sqlSession.getMapper(UserMapperDynamicSql.class);
		QueryUserPo queryUserPo = new  QueryUserPo();
		User user = new User();
		user.setName("%亮%");
		user.setSex("男");
		queryUserPo.setUser(user);
		List<User> users = mapper.findUserByNameAndSex(queryUserPo);
		System.out.println(users);
		
		
	}

	/**
	 * 根据name模糊查询用户------sql片段统计
	 */
	@Test
	public void testFindUserCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取代理创建代理对象
		UserMapperDynamicSql mapper= sqlSession.getMapper(UserMapperDynamicSql.class);
		QueryUserPo queryUserPo = new  QueryUserPo();
		User user = new User();
		user.setName("%来%");
		user.setSex("男");
		queryUserPo.setUser(user);
		int count = mapper.findUserCount(queryUserPo);
		System.out.println(count);
		
		
	}
	/**
	 * foreach
	 */
	@Test
	public void testFindUserByForeach() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取代理创建代理对象
		UserMapperDynamicSql mapper= sqlSession.getMapper(UserMapperDynamicSql.class);
		QueryUserPo queryUserPo = new  QueryUserPo();
		User user = new User();
		user.setName("%来%");
		user.setSex("男");
		queryUserPo.setUser(user);
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		queryUserPo.setIds(ids);
		List<User> users = mapper.findUserByForeach(queryUserPo);
		System.out.println(users);


	}
}
