package com.sanduo.test;

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
public class TestMapperPojo {
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
		UserMapperInner mapper= sqlSession.getMapper(UserMapperInner.class);
		QueryUserPo queryUserPo = new  QueryUserPo();
		User user = new User();
		user.setName("%亮%");
		user.setSex("男");
		queryUserPo.setUser(user);
		List<User> users = mapper.findUserByNameAndSex(queryUserPo);
		System.out.println(users);
		
	}

	/**
	 * 根据name模糊查询用户-----hashmap
	 */
	@Test
	public void testFindUserByHashMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取代理创建代理对象
		UserMapperInner mapper= sqlSession.getMapper(UserMapperInner.class);
		HashMap<Object,Object> map = new HashMap<>();
		map.put("name", "%亮%");
		map.put("sex", "男");
		/*Hashtable<Object, Object> map = new Hashtable<>();
		map.put("name", "%亮%");
		map.put("sex", null);*/
		List<User> users = mapper.findUserByHashMap(map);
		System.out.println(users);
		
	}
}
