package cn.jcet.xianlei.configure;

//import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;
import java.util.*;

/**
 *
 * 配置druid控制台
 * @author 鲜磊 on 2019/7/26
 **/
@Configuration
//判断是否包含druid这个数据源
@ConditionalOnClass(value = {DruidDataSource.class})
@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class MyConfigure {

    // 定义监控属性
    private String loginUsername;
    private String loginPassword;
    private String allow;
    private String deny;
    private String statViewServletMapping;

    //过滤器
    private String exclusions;
    private String webStatFilterPattern;


    @Bean(initMethod="init")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setMaxActive(2);
//        druidDataSource.setInitialSize(3);
        return druidDataSource;
    }

    /**
     * 监控配置
     */

    @Bean
    @ConditionalOnClass(value = StatViewServlet.class)
    public ServletRegistrationBean<StatViewServlet> getStatViewServlet(){
        //创建一个视图
        StatViewServlet servlet = new StatViewServlet();
        //创建一个新的注册器
        ServletRegistrationBean<StatViewServlet> registrationBeans = new ServletRegistrationBean<>();
        //注入servlet
        registrationBeans.setServlet(servlet);
//        注入属性值
        Map<String,String> initParamters = new HashMap<>();
        initParamters.put("loginUsername",loginUsername);
        initParamters.put("loginPassword",loginPassword);
        initParamters.put("allow",allow);
        initParamters.put("deny",deny);
        //注入参数值
        registrationBeans.setInitParameters(initParamters);
        //注入访问路径
        Collection<String> urlMapping = new ArrayList<>();
        urlMapping.add(statViewServletMapping);
        //注入
        registrationBeans.setUrlMappings(urlMapping);

        return registrationBeans;
    }


    /**
     * 注册过滤器
     */
    @Bean
    @ConditionalOnClass(value = WebFilter.class)
    public FilterRegistrationBean<WebStatFilter> getWebFilters(){

        //创建web过滤
        WebStatFilter filter = new WebStatFilter();

        //过滤注册器
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>();
        //设置过滤器
        registrationBean.setFilter(filter);

        //初始化参数
        registrationBean.addInitParameter("exclusions",exclusions);

        //拦截路径
        Collection<String> urlMapping = new ArrayList<>();
        urlMapping.add(webStatFilterPattern);
        //注入路径
        registrationBean.setUrlPatterns(urlMapping);

        return registrationBean;
    }


}
