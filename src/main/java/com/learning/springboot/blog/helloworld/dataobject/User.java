package com.learning.springboot.blog.helloworld.dataobject;

/**
 * 用户类
 * @author zcd
 *
 */
public class User {
	
	/**主键id*/
	private Long id;
	/**用户姓名*/
	private String name;
	/**用户邮箱*/
	private String email;
	
	/**无参的构造方法*/
	public User(){
		
	}
	/**带参构造方法*/
	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	/**set、get方法*/
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
