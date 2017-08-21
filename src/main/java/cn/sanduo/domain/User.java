package cn.sanduo.domain;
/**
 * user实体类
 * @author sanduo
 *
 */
public class User {
	private Integer id;
	private String name;
	private String telephone;
	private String sex;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telephone=" + telephone + ", sex=" + sex + "]";
	}

	
	

}
