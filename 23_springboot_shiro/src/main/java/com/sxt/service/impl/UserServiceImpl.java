package com.sxt.service.impl;

import com.sxt.utils.EncodingUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.domain.User;
import com.sxt.mapper.UserMapper;
import com.sxt.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUserName(String userName) {
		return userMapper.queryUserByUserName(userName);
	}

	@Override
	public Integer insert(User user) {
		/**
		 * 对密码进行加密
		 */
		String pssword = EncodingUtils.encode(user.getAddress() + user.getUserpwd(), user.getUserpwd());
		user.setUserpwd(pssword);
		return userMapper.insert(user);
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.queryUserByUserName(username);
	}


}
