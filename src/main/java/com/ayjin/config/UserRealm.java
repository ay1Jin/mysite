package com.ayjin.config;

import com.ayjin.pojo.User;
import com.ayjin.service.UserService.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("正在执行授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的这个对象。
        Subject subject = SecurityUtils.getSubject();
        //取出认证出的权限。
        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getRights());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("正在执行认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //查询数据库，如果返回值为空，返回错误信息。
        User user = userService.queryUserByname(userToken.getUsername());
        if (user==null){
            return null;
        }
        //进行密码认证。
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}