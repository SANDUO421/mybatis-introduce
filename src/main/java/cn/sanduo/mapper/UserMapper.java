package cn.sanduo.mapper;

import java.util.List;

import cn.sanduo.domain.User;

/**
 * 映射配置dao------mapper代理
 * @Description
 * @author sanduo
 */
public interface UserMapper {
	/**
	 * 命名空间：cn.sanduo.mapper.UserMapper<->namespace
	 * 返回值：user<->resultType
	 * 方法名：findUserById<->id
	 * 参数类型：Integer<->parameterType
	 * @param id
	 * @return
	 */
	//根据用户id查询用户
	public User findUserById(Integer id);
	//模糊查询通多name
	public List<User> findUserByLikeName(String name); 
	

}
