package com.learning.springboot.blog.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springboot.blog.helloworld.dataobject.User;
import com.learning.springboot.blog.helloworld.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model){
		model.addAttribute("userList",userRepository.findAll());
		model.addAttribute("title","用户管理");
		return new ModelAndView("users/list","userModel",model);
	}
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id")Long id,Model model){
		User user = userRepository.findUserById(id);
		model.addAttribute("user",user);
		model.addAttribute("title","查看用户");
		return new ModelAndView("users/view","userModel",model);
	}
	
	/**
	 * 获取创建表单页面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView form(Model model){
		User user = new User();
		model.addAttribute("user",user);
		model.addAttribute("title","创建用户");
		return new ModelAndView("users/form","userModel",model);
	}
	
	/**
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user,Model model){
		userRepository.saveOrUpdateUser(user);
		return new ModelAndView("redirect:/users");  //重定向到list页面
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id")Long id ,Model model){
		userRepository.deleteUserById(id);
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/modify/{id}")
	public ModelAndView modifyUser(@PathVariable("id")Long id ,Model model){
		User user = userRepository.findUserById(id);
		model.addAttribute("user",user);
		model.addAttribute("title","修改用户");
		return new ModelAndView("users/form","userModel",model);
	}
}
