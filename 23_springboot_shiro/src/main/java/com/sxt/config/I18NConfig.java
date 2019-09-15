package com.sxt.config;

import com.sxt.controller.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author 鲜磊 on 2019/9/12
 **/
@Configuration
public class I18NConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // 是否加载消息
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(false);
        // 设置spring读取的配置文件的前缀
//        messageSource.setBasename("loginController");
        // messageSource.setBasenames("person","student");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(2);
        return messageSource;
        /*
         * setBaseName设置消息源的文件名，messageSource.setBasename("application");，
         * 表明消息源是以applicition打头的属性文件，如果要设置多个属性文件作为消息源，那么就要用setBaseNames方法来设置，比如：
         * messageSource.setBasenames("student", "application");
         * 这样就有两个消息源：student.properties和application.properties。
         */
    }

}
