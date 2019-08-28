package cn.jcet.realm;

import cn.jcet.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

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
        User user = new User("zhangsan","5975ed4c545c041893fee70ae9653990",1);
        if(user == null){
            return null; //用户名不存在
        }else{

             /**
             * 参数1：principal   用户名【身份】
             * 参数2：credentials  密码【证明】  数据库里面的密码
             * 参数3：realmName realm的名字
             */

              //if(!username.equals("zhangsan")){
              //throw  new UnknownAccountException("=====>"+username+"用户名不存在！");
             //}

            //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            //System.out.println(info);
             /**
             *  参数1:principal, 用户名【身份】
             *  参数2:hashedCredentials,  密码【证明】  数据库里面的密码   为证明被加密了
             *  参数3:credentialsSalt,   混淆的加密串
             *  参数4:realmName  realm的名字
             */
            ByteSource credentialsSalt = ByteSource.Util.bytes("南京");
            SimpleAuthenticationInfo info2 = new SimpleAuthenticationInfo(user,user.getPassword(),credentialsSalt,getName());
            /**
             * 如果返回为null 就页面false 验证不通过
             */
            return info2;
        }

    }

    /**
     *  授权凭证
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        principalCollection.getPrimaryPrincipal();
        return null;
    }

}
