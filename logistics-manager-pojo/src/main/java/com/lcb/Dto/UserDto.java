package com.lcb.Dto;

import java.util.List;

import com.lcb.pojo.User;

public class UserDto {
	private User user;
	private List<Integer> roleIds;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
}
