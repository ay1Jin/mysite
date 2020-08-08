package com.ayjin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //1.创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //2.将默认的网络安全管理员DefaultWebSecurityManager与realm对象联系。然后返回一个安全管理员
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //3.给安全管理员安排一个ShiroFilterFactoryBean方便其对网站进行管控。
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证才可以访问
            user: 必须拥有记住我 功能才可以访问
            perms: 拥有对某个资源的权限才可以访问。
            role: 拥有某个角色权限才可以访问。
         */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
        //权限,如果没有权限则跳转。记住一定要先把要授权的写在前面。
        filterMap.put("/admin/**","perms[admin]");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        bean.setLoginUrl("/login");

        //未授权跳转回主页面。
        bean.setUnauthorizedUrl("/index");

        return bean;
    }

    //整合shiro+thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
