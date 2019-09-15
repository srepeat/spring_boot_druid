package com.sxt.service;

import java.util.List;

public interface RoleService {

	/**
	 * 根据用户ID设查询角色返回List<String>
	 */
	List<String> queryRolesByUserId(Integer userId);
}
