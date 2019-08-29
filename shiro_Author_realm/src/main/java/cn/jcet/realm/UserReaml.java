package cn.jcet.realm;

import cn.jcet.domain.User;
import cn.jcet.domain.UserActive;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 鲜磊 on 2019/8/25
 *
 * 实现自定义接口
 **/
public class UserReaml extends AuthorizingRealm{
    /**
     * 获取realm的名称
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证登录凭证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户
        String username = token.getPrincipal().toString();
        System.out.println(username);
        //凭证
//        String password = token.getCredentials().toString();
//        System.out.println(password);
        User user = new User("zhangsan", "123456", 1);
        if (user != null) {
            /**
             * 添加角色
             */
            List<String> roles = new ArrayList<>();
            roles.add("role1");
            roles.add("role2");

            /**
             * 添加权限
             */
            List<String> permissions = new ArrayList<>();
            permissions.add("user:view");
            permissions.add("user:create");
            permissions.add("user:delete");
            permissions.add("user:update");

            /**
             * 传入
             */
            UserActive userActive = new UserActive(user,roles,permissions);

            /**
             * 参数1：principal   用户名【身份】
             * 参数2：credentials  密码【证明】  数据库里面的密码
             * 参数3：realmName realm的名字
             */

            //if(!username.equals("zhangsan")){
            //throw  new UnknownAccountException("=====>"+username+"用户名不存在！");
            //}

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userActive,user.getPassword(),getName());
            //System.out.println(info);
            /**
             *  参数1:principal, 用户名【身份】
             *  参数2:hashedCredentials,  密码【证明】  数据库里面的密码   为证明被加密了
             *  参数3:credentialsSalt,   混淆的加密串
             *  参数4:realmName  realm的名字
             */
//            ByteSource credentialsSalt = ByteSource.Util.bytes("南京");
//            SimpleAuthenticationInfo info2 = new SimpleAuthenticationInfo(userActive, user.getPassword(), credentialsSalt, getName());
            /**
             * 如果返回为null 就页面false 验证不通过
             */
            return info;
        }

        return null;

        }

    /**
     *  授权凭证
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserActive userActive = (UserActive) principalCollection.getPrimaryPrincipal();
//        System.out.println(primaryPrincipal);
        System.out.println(userActive.getClass().getSimpleName());
//
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

//        Collection<String> roles = new ArrayList<>();
//        roles.add("role1");
//        roles.add("role2");
        if(userActive.getRoles()!=null && userActive.getRoles().size()>0){
            info.addRoles(userActive.getRoles());
        }
//        /**
//         * 添加权限
//         */
//        Collection<String> perssiom = new ArrayList<>();
//        perssiom.add("user:view");
//        perssiom.add("user:create");
//        perssiom.add("user:delete");
//        perssiom.add("user:update");
        if(userActive.getPerssiom() != null && userActive.getPerssiom().size()>0){
            info.addStringPermissions(userActive.getPerssiom());
        }

        return info;
    }

}
