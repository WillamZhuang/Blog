package com.learning.springboot.blog.helloworld.repository;

import java.util.List;

import com.learning.springboot.blog.helloworld.dataobject.User;

public interface UserRepository {

	/**
	 * 创建或修改用户
	 */
	public User saveOrUpdateUser(User user);
	
	/**
	 * 删除用户
	 */
	public void deleteUserById(Long id);
	
	/**
	 *通过id查找用户 
	 */
	public User findUserById(Long id);
	
	/**
	 * 列举所有用户
	 */
	public List<User> findAll();
	
}
