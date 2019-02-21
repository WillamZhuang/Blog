package com.learning.springboot.blog.helloworld.repository;

import java.util.List;

import com.learning.springboot.blog.helloworld.dataobject.User;

public interface UserRepository {

	/**
	 * �������޸��û�
	 */
	public User saveOrUpdateUser(User user);
	
	/**
	 * ɾ���û�
	 */
	public void deleteUserById(Long id);
	
	/**
	 *ͨ��id�����û� 
	 */
	public User findUserById(Long id);
	
	/**
	 * �о������û�
	 */
	public List<User> findAll();
	
}
