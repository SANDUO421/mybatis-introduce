package cn.sanduo.dao;

import cn.sanduo.domain.User;

/**
 * Userdao------原生的到编写
 * @Description
 * @author sanduo
 */
public interface UserDao {

	public User findUserById(Integer id);
}
