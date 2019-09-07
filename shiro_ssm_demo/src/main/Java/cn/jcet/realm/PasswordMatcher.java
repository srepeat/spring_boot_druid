package cn.jcet.realm;

import cn.jcet.pojo.User;
import cn.jcet.util.ActiverUser;
import cn.jcet.util.EncodingUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

/**
 * @author 鲜磊 on 2019/9/4
 **/
@Component
public class PasswordMatcher extends SimpleCredentialsMatcher {


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        ActiverUser activerUser = (ActiverUser) info.getPrincipals().getPrimaryPrincipal();
        String password = new String((char[]) token.getCredentials());
        User user = activerUser.getUser();
        String encode = EncodingUtils.encode(user.getAddress(), password);
        return encode.equals(user.getUserpwd());
    }
}
