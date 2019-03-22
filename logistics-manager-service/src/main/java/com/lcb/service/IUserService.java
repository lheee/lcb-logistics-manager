package com.lcb.service;

import java.util.List;

import org.springframework.ui.Model;

import com.lcb.Dto.UserDto;
import com.lcb.pojo.User;

public interface IUserService {

	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<User> query(User user);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUser(int id);
	
	/**
	 * 获取修改或添加所需要的用户和角色信息
	 * 添加时：获取用户和角色列表
	 * 修改时：获取用户和角色列表以及根据id查询到的用户信息
	 * @param id
	 * @param model
	 */
	public void getUpdateUserInfo(Integer id, Model model);

	/**
	 * 保存或修改用户角色关联表
	 * @param userDto
	 */
	public void saveOrUpdate(UserDto userDto);
}
