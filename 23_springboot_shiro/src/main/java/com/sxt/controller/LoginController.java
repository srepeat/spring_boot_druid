package com.sxt.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sxt.common.AbstractServlet;
import com.sxt.common.Resp;
import com.sxt.domain.User;
import com.sxt.domain.UserVo;
import com.sxt.service.UserService;
import com.sxt.utils.EncodingUtils;
import com.sxt.utils.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.sxt.utils.ActiverUser;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.lang.System.out;
import static sun.misc.MessageUtils.out;

@Controller
@RequestMapping("login")
public class LoginController extends AbstractServlet{

	@Autowired
	private UserService userService;


	/**
	 * 查询用户名是否存在
	 * @param username
	 * @param response
	 */
	@GetMapping("/findByUserName")
	@ResponseBody
	public void findByUserName(@RequestParam("username") String username, HttpServletResponse response){
			if (StringUtils.isBlank(username)) {
				out(response, Resp.builder().setMessage("用户名不能为空").setState(false).setStatus(500));
			}
			User user = userService.findByUsername(username);
			if (ObjectUtils.isEmpty(user)) {
				out(response, Resp.builder().setMessage("用户名可以使用").setState(true).setStatus(200));
			} else {
				out(response, Resp.builder().setMessage("用户名已存在").setState(false).setStatus(401));
			}
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/insertUser")
	@ResponseBody
	public Map<String,Object> insertUser(User user){
		Map<String,Object> map = new HashMap<>();
		Integer users = userService.insert(user);
		if(users > 0) {
			map.put("msg","ok");
			map.put("success", "success");
			out.println("==>" + user.getUserpwd());
		}

		/*{
			map.put("msg","error");
			map.put("error","error");
		}*/
		  return map;
	}

	/**
	 * 跳转登录页面
	 */
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}

	/**
	 * 跳转登录页面
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister(){


		return "register";
	}

	/**
	 * 登陆
	 */
	@RequestMapping("/login")
	public String login(UserVo userVo, Model model, HttpSession session) {
		UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getUserpwd());
		// 4.创建主体 只要线程不变,Subject不变
		Subject subject = SecurityUtils.getSubject();
		try {
			out.println("认证成功[登陆成功]");
			// 5登陆
			subject.login(token);
			ActiverUser activerUser=(ActiverUser) subject.getPrincipal();
			session.setAttribute("user", activerUser.getUser());
//			System.out.println("====>"+activerUser.getUser());
			return "list";
		} catch (UnknownAccountException e) {
			out.println("用户名不存在");
			model.addAttribute("error", "用户名不存在");
		} catch (IncorrectCredentialsException e) {
			out.println("密码不正确");
			model.addAttribute("error", "密码不正确");
		}
		return "login";
	}

}
