package cn.jcet.realm;

import cn.jcet.pojo.Role;
import cn.jcet.pojo.User;
import cn.jcet.service.PermissionService;
import cn.jcet.service.RoleService;
import cn.jcet.service.UserService;
import cn.jcet.util.ActiveUser;
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
import org.springframework.stereotype.Component;


/**
 * @author 鲜磊 on 2019/9/1
 **/
@Component
public class UserRealm extends AuthorizingRealm{


    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;




    public String getName(){
        return this.getClass().getSimpleName();
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        ActiveUser activerUser = (ActiveUser) principalCollection.getPrimaryPrincipal();


        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        if(activerUser.getRoles() != null && activerUser.getRoles().size() >0){
            info.addRoles(activerUser.getRoles());
        }

        if(activerUser.getPermissions() != null && activerUser.getPermissions().size() >0){
            info.addStringPermissions(activerUser.getPermissions());
        }


        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名称
        String username = authenticationToken.getPrincipal().toString();

        //根据用户名去数据库查询
        User user = this.userService.queryByUserName(username);

        ActiveUser activeUser = new ActiveUser();

        if(user != null){
            activeUser.setUser(user);

            //根据用户id查询角色
            activeUser.setRoles(roleService.queryRoleByUserId(user.getUserid()));

            //根据权限角色查询
            activeUser.setPermissions(permissionService.queryPermissionByUserId(user.getUserid()));

            //加盐
            ByteSource salt = ByteSource.Util.bytes(user.getUsername()+user.getAddress());
            AuthenticationInfo  info =  new SimpleAuthenticationInfo(activeUser,user.getUserpwd(),salt,getName());

            return info;
        }else{
            //如果用户名不存在的情况就不捕捉异常，直接返回null

            return null;
        }
    }
}
