package com.sxt.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.domain.User;
import com.sxt.service.PermissionService;
import com.sxt.service.RoleService;
import com.sxt.service.UserService;
import com.sxt.utils.ActiverUser;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 认证的
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		// 得到用户名
		String userName = token.getPrincipal().toString();
		// 根据用户名查询用户
		User user = this.userService.queryUserByUserName(userName);
		if (null == user)

			return null;

		ActiverUser activerUser = new ActiverUser();
		// 设置用户
		activerUser.setUser(user);
		// 查询当前用户的角色
		activerUser.setRoles(this.roleService.queryRolesByUserId(user.getUserid()));
		// 查询当前用户的权限
		activerUser.setPermissions(this.permissionService.queryPermissionByUserId(user.getUserid()));

		/**
		 * 你的盐池 ByteSource.Util.bytes(user.getUsername()+user.getAddress());
		 * 创建用户时密码得是这个(password + salt.toString())
		 **/
		//ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername()+user.getAddress());
		//activerUser.setSalt(credentialsSalt);
		//AuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(activerUser, user.getUserpwd(), getName());
		return new SimpleAuthenticationInfo(activerUser,user.getUserpwd(),getName());
	}
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiverUser activerUser=(ActiverUser) principals.getPrimaryPrincipal();
		List<String> roles = activerUser.getRoles();
		List<String> permissions = activerUser.getPermissions();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		if(null!=roles&&roles.size()>0) {
			info.addRoles(roles);
		}
		if(null!=permissions&&permissions.size()>0) {
			info.addStringPermissions(permissions);
		}
		return info;
	}

	

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

}
