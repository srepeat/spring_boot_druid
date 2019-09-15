package com.sxt.service;

import java.util.List;

public interface PermissionService {

	/**
	 * 根据用户ID设查询权限返回List<String>
	 */
	List<String> queryPermissionByUserId(Integer userId);
}
