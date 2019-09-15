package com.sxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.domain.Permission;
import com.sxt.mapper.PermissionMapper;
import com.sxt.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<String> queryPermissionByUserId(Integer userId) {
		List<Permission> list = permissionMapper.queryPermissionsByUserId(userId);
		List<String> data=new ArrayList<>();
		
		for (Permission permission : list) {
			data.add(permission.getPercode());
		}
		return data;
	}

}
