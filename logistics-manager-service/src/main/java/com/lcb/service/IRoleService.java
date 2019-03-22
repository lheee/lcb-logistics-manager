package com.lcb.service;

import java.util.List;

import com.lcb.pojo.Role;

/**
 * 角色事务接口
 * @author 恒
 *
 */
public interface IRoleService {
	/**
	 * 根据条件查询角色
	 * @param role
	 * @return
	 */
	public List<Role> query(Role role);
	
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * 根据条件更新角色信息
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * 根据ID删除角色
	 * @param id
	 */
	public void deleteRole(int id);
}
