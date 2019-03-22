package com.lcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcb.pojo.Role;
import com.lcb.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private IRoleService roleService;
	
	/**
	 * 根据条件查询角色列表并返回jsp页面
	 * @return
	 */
	@RequestMapping("/query")
	public String query(Role role, Model model){
		System.out.println("查询时角色信息:"+role.getRoleName());
		List<Role> roleList = roleService.query(role);
		model.addAttribute("list", roleList);
		return "role/role";
	}
}
