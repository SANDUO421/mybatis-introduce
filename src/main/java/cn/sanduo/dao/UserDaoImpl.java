package cn.sanduo.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.sanduo.domain.User;
/**
 * 原生的到编写
 * @Description
 * @author sanduo
 */
public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;



	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}



	@Override
	public User findUserById(Integer id) {
		//根据id查询用户 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById",id);
	}



}
