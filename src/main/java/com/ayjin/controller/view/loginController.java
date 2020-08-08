package com.ayjin.controller.view;

import com.ayjin.mapper.UserMapper;
import com.ayjin.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
        try {
            subject.login(token);
            return "redirect:/index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在！");
            return "view/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误！");
            return "view/login";
        }
    }

}
