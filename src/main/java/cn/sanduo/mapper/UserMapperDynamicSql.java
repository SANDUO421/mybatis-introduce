package cn.sanduo.mapper;

import java.util.List;

import cn.sanduo.domain.QueryUserPo;
import cn.sanduo.domain.User;

/**
 * 映射配置dao-----动态sql
 * @Description
 * @author sanduo
 */
public interface UserMapperDynamicSql {
	/**
	 * 命名空间：cn.sanduo.mapper.UserMapper<->namespace
	 * 返回值：user<->resultType
	 * 方法名：findUserById<->id
	 * 参数类型：Integer<->parameterType
	 * @return
	 */
	//模糊查询通多name
	public List<User> findUserByNameAndSex(QueryUserPo po);
	
	public Integer findUserCount(QueryUserPo po);

	public List<User> findUserByForeach(QueryUserPo po);

}
