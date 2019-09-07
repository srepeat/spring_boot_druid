package cn.jcet.realm;

import cn.jcet.pojo.User;
import cn.jcet.service.PermissionService;
import cn.jcet.service.RoleService;
import cn.jcet.service.UserService;
import cn.jcet.util.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author 鲜磊 on 2019/9/1
 **/
//@Component("userRealm")
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;


    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }


    /**
     * 认证的
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        User user = this.userService.queryUserByUserName(userName);
        if(user == null)
            return null;
        ActiverUser activerUser = new ActiverUser();
        activerUser.setUser(user);
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

}
