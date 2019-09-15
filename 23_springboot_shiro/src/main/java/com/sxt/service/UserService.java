package com.sxt.service;

import com.sxt.domain.User;

public interface UserService {

	/**
	 * 根据用户名查询用户
	 */
	User queryUserByUserName(String userName);

	/**
	 * 新增
	 * @param user
	 * @return
	 */
	public Integer insert(User user);

	/**
	 * 查询用户名
 	 * @param username
	 * @return
	 */
    User findByUsername(String username);
}
