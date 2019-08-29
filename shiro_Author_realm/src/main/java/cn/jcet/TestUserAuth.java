package cn.jcet;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 鲜磊 on 2019/8/25
 **/
public class TestUserAuth {

    public static void main(String[] args) {

        //创建用户名和密码
        String username = "zhangsan";
        String password = "123456";

        //1、创建securityManager工厂,导入shiro自带的包
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2、创建securityManager
        SecurityManager securityManager = factory.getInstance();
        //3、将securityManager绑定到运行环境
        SecurityUtils.setSecurityManager(securityManager);
        //4、创建一个主体
        Subject subject = SecurityUtils.getSubject();
        //5、token里面放入密码,将密码进行一个封装
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //6、使用主体去调用 shiro里面的默认realm去认下
            subject.login(token);
            System.out.println("认证成功[登陆成功]");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码不正确");
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在 ");
        }
        //7、判断认证状态
        System.out.println("是否认证"+subject.isAuthenticated());
        //8、判断用户是否拥有角色
        System.out.println("用户是否拥有role1角色==>"+subject.hasRole("role1"));
        //9、判断用户是否有role1,role2的角色  返回一个boolean的数组
        List<String> rolelist = new ArrayList<>();
        rolelist.add("role1");
        rolelist.add("role2");
//        rolelist.add("role3");
        System.out.println("用户是否拥有role1、role2角色==>"+ Arrays.toString(subject.hasRoles(rolelist)));
//        //10、判断用户是否同时拥有有role1,role2的角色  返回一个boolean
        System.out.println("户是否同时拥有有role1,role2的角色==>" + subject.hasAllRoles(rolelist));
        //11、判断用户是否有user:create的权限
        System.out.println("用户是否有user:create的权限==>" + subject.isPermitted("user:create"));
        //12、判断用户是否有user:create,user:delete的权限
        String [] perimsess = {"user:view","user:update"};
        boolean[] permitted = subject.isPermitted(perimsess);
        System.out.println("用户是否有user:create,user:delete的权限==>" + Arrays.toString(permitted));
        //13、判断用户是否同时拥有有user:create,user:update的权限
        System.out.println("用户是否同时拥有有user:create,user:update的权限==>" + subject.isPermittedAll(perimsess));


        //14、注销
        subject.logout();
        System.out.println("是否认证==>"+subject.isAuthenticated());
    }
}
