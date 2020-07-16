package com.ayjin.controller.view;

import com.ayjin.mapper.UserMapper;
import com.ayjin.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;


@Controller
@Api("登录")
public class loginController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("登陆页面")
    @GetMapping("/login")
    public String login(){
        return "view/login";
    }


    @ApiOperation("提交登录")
    @RequestMapping("/login")
    public String toLogin(
            @RequestParam("username")String name,
            @RequestParam("password")String password,
            Model model
    ){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //查询账号密码
        User user = userMapper.queryUserByName(name);
        if (!StringUtils.isEmpty(name) && user.getPassword().equals(password)){
            subject.login(token);
            //返回后台页面
            return "admin/viewers";
        }else {
            model.addAttribute("msg","账户或密码错误！");
            return "view/login";
        }
    }

}
