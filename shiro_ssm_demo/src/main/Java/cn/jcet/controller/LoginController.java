package cn.jcet.controller;

import cn.jcet.pojo.UserVo;
import cn.jcet.util.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){

        return "login";
    }

    /**
     * 登录认证
     */
    @RequestMapping("login")
    public String login(UserVo userVo, HttpSession session, Model model){
        //创建token
        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(),userVo.getUserpwd());

        Subject subject = SecurityUtils.getSubject();

        try{
            System.out.println("认证成功[登陆成功]");

            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            //存入session
            session.setAttribute("user",activeUser.getUser());
            return "list";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
            model.addAttribute("error", "密码不正确");
        } catch (UnknownAccountException e) {
            System.out.println("用户不存在");
            model.addAttribute("error", "用户不存在");
        }
        return "login";
    }
}
