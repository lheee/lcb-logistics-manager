package com.lcb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcb.Dto.UserDto;
import com.lcb.pojo.User;
import com.lcb.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	/**
	 * 根据条件查询角色列表并返回jsp页面
	 * @return
	 */
	@RequestMapping("/query")
	public String query(User user, Model model){
		List<User> userList = userService.query(user);
		model.addAttribute("list", userList);
		return "user/user";
	}
	
	/**
	 * 进入添加或修改页面前触发的方法
	 * 得到查询修改或添加所需的数据
	 * @param id	选中的用户
	 * @param model
	 * @return	jsp页面
	 */
	@RequestMapping("/userUpdate")
	public String userUpdatePage(Integer id, Model model){
		userService.getUpdateUserInfo(id, model);
		return "user/update";
	}
	
	/**
	 * 保存添加或修改的数据
	 * @param userDto
	 * @return	重定向到此类的query方法
	 */
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(UserDto userDto){
		userService.saveOrUpdate(userDto);
		return "redirect:/user/query";
	}
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteUser(Integer id){
		userService.deleteUser(id);
		return "redirect:/user/query";
	}
}
