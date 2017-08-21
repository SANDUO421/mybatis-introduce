package cn.sanduo.domain;

import java.util.List;

/**
 * 包装类-------------用于多条件查询
 * @Description
 * @author sanduo
 */
public class QueryUserPo {
	//定义多个查询条件：将pojo包装。成一个对象；
	
	//用户查询条件
	private User user;
	//订单查询条件
	//商品查询条件
	//...
	private List<Integer> ids;
	//用户id用于向mybatis传递多个id
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "QueryUserPo [user=" + user + "]";
	}
	
}
