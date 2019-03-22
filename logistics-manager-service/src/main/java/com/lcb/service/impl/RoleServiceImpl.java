package com.lcb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcb.mapper.RoleMapper;
import com.lcb.pojo.Role;
import com.lcb.pojo.RoleExample;
import com.lcb.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Resource
	private RoleMapper mapper;

	@Override
	public List<Role> query(Role role) {
		// TODO Auto-generated method stub
		RoleExample example = new RoleExample();
		if(role != null){
			if(!"".equals(role.getRoleName()) && role.getRoleName()!=null){
				//模糊查询
				example.createCriteria().andRoleNameLike("%"+role.getRoleName()+"%");
			}
		}
		return mapper.selectByExample(example);
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		mapper.insertSelective(role);

	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(role);

	}

	@Override
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}

}
