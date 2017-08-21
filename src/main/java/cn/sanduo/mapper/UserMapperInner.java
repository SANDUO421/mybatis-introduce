package cn.sanduo.mapper;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import cn.sanduo.domain.QueryUserPo;
import cn.sanduo.domain.User;

/**
 * 映射配置dao------mapper代理
 * @Description
 * @author sanduo
 */
public interface UserMapperInner {
	/**
	 * 命名空间：cn.sanduo.mapper.UserMapper<->namespace
	 * 返回值：user<->resultType
	 * 方法名：findUserById<->id
	 * 参数类型：Integer<->parameterType
	 * @param id
	 * @return
	 */
	//模糊查询
	public List<User> findUserByNameAndSex(QueryUserPo queryUserPo);
	
	public List<User> findUserByHashMap(HashMap<Object, Object> hashMap);
	/*public List<User> findUserByHashMap(Hashtable<Object, Object> hashtable);*/
	

}
