package com.learning.springboot.blog.helloworld.dataobject;

/**
 * �û���
 * @author zcd
 *
 */
public class User {
	
	/**����id*/
	private Long id;
	/**�û�����*/
	private String name;
	/**�û�����*/
	private String email;
	
	/**�޲εĹ��췽��*/
	public User(){
		
	}
	/**���ι��췽��*/
	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	/**set��get����*/
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
