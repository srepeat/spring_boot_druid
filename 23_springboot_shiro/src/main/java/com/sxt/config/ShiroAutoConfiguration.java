package com.sxt.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.sxt.domain.User;
import com.sxt.realm.UserRealm;
import com.sxt.utils.ActiverUser;
import com.sxt.utils.EncodingUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * shrio的自动配置类
 * 
 * @author LJH
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "shiro")
@Slf4j
public class ShiroAutoConfiguration {

//	private String hashAlgorithmName="md5";
//	private int hashIterations=2;
	private String loginUrl = "/index.html"; // 登陆页面
	private String unauthorizedUrl = "/unauthorize.html"; // 未授权的页面

	private String[] anonUrls; // 放行的url
	private String logoutUrl;// 登出的URL
	private String[] authcUrls;// 需要认证的url

	/**
	 * 声明凭证匹配器
	 */
	@Bean("simpleCredentialsMatcher")
	public CredentialsMatcher getHashedCredentialsMatcher() {
		/*HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		// 注入加密方式
		credentialsMatcher.setHashAlgorithmName(hashAlgorithmName);
		// 注入散列次数
		credentialsMatcher.setHashIterations(hashIterations);*/

		return (AuthenticationToken token,AuthenticationInfo info) ->{
//			String dbPassword = info.getPrincipals().toString();
			//获取凭证
			/*ActiverUser activerUser = (ActiverUser) info.getPrincipals().getPrimaryPrincipal();
			String password = new String((char[]) token.getCredentials());
			System.out.println(password);
			//ByteSource salt = activerUser.getSalt();
			//String newPassword = DigestUtils.md5DigestAsHex((password + salt.toString()).getBytes());
			User user = activerUser.getUser();

			String encode = EncodingUtils.encode(user.getAddress() + user.getUsername(), password);
			System.out.println(user.getUsername());
			System.out.println(user.getUserpwd());

			return encode.equals(user.getUserpwd());*/

			ActiverUser activerUser = (ActiverUser) info.getPrincipals().getPrimaryPrincipal();
			String password = new String((char[]) token.getCredentials());
			User user = activerUser.getUser();
			//encode传入的加密方式  这个使用地址和用户名作为加密的方式之一
			String encode = EncodingUtils.encode(user.getAddress()+user.getUsername(), password);
//       	 System.out.println(encode);
			System.out.println(user.getUserpwd());
      	  System.out.println(user.getAddress()+"<-->"+user.getUsername());
			return encode.equals(user.getUserpwd());
		};
	}

	/**
	 * 声明Realm
	 * @Qualifier  按照bean名称注入
	 */
	@Bean("userRelam")
	public UserRealm getUserRealm(@Qualifier("simpleCredentialsMatcher") CredentialsMatcher credentialsMatcher) {
		UserRealm realm = new UserRealm();
		// 注入凭证匹配器
		realm.setCredentialsMatcher(credentialsMatcher);
		return realm;
	}

	/**
	 * 声明securityManager
	 */
	@Bean
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRelam") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 注入realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	/**
	 * Shiro 的Web过滤器
	 */
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		// Shiro的核心安全接口
		factoryBean.setSecurityManager(securityManager);
		// 注入未登陆的跳转页面
		factoryBean.setLoginUrl(loginUrl);
		// 注入未授权的跳转页面
		factoryBean.setUnauthorizedUrl(unauthorizedUrl);
		Map<String, String> filterChainDefinitionMap = new HashMap<>();
		if (this.checkArrayIsEmpty(anonUrls)) {
			for (String url : anonUrls) {
				filterChainDefinitionMap.put(url, "anon");
			}
		}
		filterChainDefinitionMap.put(logoutUrl, "logout");
		if (this.checkArrayIsEmpty(authcUrls)) {
			for (String url : authcUrls) {
				filterChainDefinitionMap.put(url, "authc");
			}
		}
		// 注入过滤器链
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;

	}

	/**
	 * //加入注解的使用，不加入这个注解不生效
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 注入委托过滤器
	 */
	@Bean
	public FilterRegistrationBean<DelegatingFilterProxy> getDelegatingFilterProxy() {
		DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
		filterProxy.setTargetFilterLifecycle(true);
		filterProxy.setTargetBeanName("shiroFilter");

		FilterRegistrationBean<DelegatingFilterProxy> bean = new FilterRegistrationBean<>();

		bean.setFilter(filterProxy);
		return bean;
	}

	// 这里是为了能在html页面引用shiro标签，上面两个函数必须添加，不然会报错
	@Bean(name = "shiroDialect")
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

	/**
	 * 检查数组是否为空
	 * 
	 * @param arrays
	 * @return
	 */
	// @RequiresRoles("超级管理员")
	public boolean checkArrayIsEmpty(String[] arrays) {
		if (this.anonUrls != null && this.anonUrls.length > 0) {
			return true;
		} else {
			return false;
		}
	}

}
