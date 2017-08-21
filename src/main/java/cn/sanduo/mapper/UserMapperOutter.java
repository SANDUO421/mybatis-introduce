package cn.sanduo.mapper;

import cn.sanduo.domain.QueryUserPo;
import cn.sanduo.domain.User;

/**
 * 映射配置dao------mapper代理
 * @Description
 * @author sanduo
 */
public interface UserMapperOutter {
	/**
	 * 命名空间：cn.sanduo.mapper.UserMapper<->namespace
	 * 返回值：user<->resultType
	 * 方法名：findUserById<->id
	 * 参数类型：Integer<->parameterType
	 * @param id
	 * @return
	 */
	//模糊查询----------------输出映射
	public Integer findUserCount(QueryUserPo queryUserPo);
	
	public User findUserByIdResultIsHashMap(Integer id);
	

}
