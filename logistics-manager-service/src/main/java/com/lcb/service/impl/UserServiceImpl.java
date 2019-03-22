package com.lcb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lcb.Dto.UserDto;
import com.lcb.mapper.RoleMapper;
import com.lcb.mapper.UserMapper;
import com.lcb.pojo.Role;
import com.lcb.pojo.RoleExample;
import com.lcb.pojo.User;
import com.lcb.pojo.UserExample;
import com.lcb.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<User> query(User user) {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertSelective(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void getUpdateUserInfo(Integer id, Model model) {
		// TODO Auto-generated method stub
		// 如果id不为空就根据id查询一条user信息
		if (id != null && id > 0) {
			User user = userMapper.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		}
		UserExample example = new UserExample();
		List<User> userList = userMapper.selectByExample(example);
		RoleExample roleExample = new RoleExample();
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		model.addAttribute("users", userList);
		model.addAttribute("roles", roleList);
	}

	@Override
	public void saveOrUpdate(UserDto userDto) {
		// TODO Auto-generated method stub
		System.out.println("进来service层了");
		if (userDto != null) {
			User user = userDto.getUser();
			List<Integer> roleIds = userDto.getRoleIds();
			System.out.println("user的值"+user.toString()+user.getUserName());
			// 判断user的id属性是否有值
			if (user.getUserId() != null && user.getUserId() > 0) {// 有值说明时修改操作

			} else {// 没值说明是添加操作,同时添加两张表,事务
				System.out.println("添加操作");
				//添加user表,添加成功后得到生成的对应id
				userMapper.insert(user);
				System.out.println(user.getUserId());
				if(roleIds!=null && roleIds.size()>0){//添加用户和角色管理表
					for (Integer roleId : roleIds) {
						userMapper.inserUserAndRoleId(user.getUserId(), roleId);
					}
					System.out.println("应该成功了");
				}
			}
		}
	}
}
