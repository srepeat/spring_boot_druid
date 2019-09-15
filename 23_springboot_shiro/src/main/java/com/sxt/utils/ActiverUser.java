package com.sxt.utils;

import java.util.List;

import com.sxt.domain.User;
import org.apache.shiro.util.ByteSource;

public class ActiverUser {
	
	private User user;
	private List<String> roles;
	private List<String> permissions;
	private ByteSource salt;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}


	public void setSalt(ByteSource salt) {
		this.salt = salt;
	}

	public ByteSource getSalt() {
		return salt;
	}
}
