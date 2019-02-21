package com.learning.springboot.blog.helloworld.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.learning.springboot.blog.helloworld.dataobject.User;
import com.learning.springboot.blog.helloworld.repository.UserRepository;
import com.sun.javafx.collections.MappingChange.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{
	/**计数器，记录id*/
	private static AtomicLong counter = new AtomicLong();
	/**用于存储用户实体对象*/
	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
	@Override
	public User saveOrUpdateUser(User user) {
		Long id = user.getId();
		if(id == null){
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		this.userMap.remove(id);
	}

	@Override
	public User findUserById(Long id) {
		return this.userMap.get(id);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = new ArrayList<>(this.userMap.values());
		return userList;
	}

}
