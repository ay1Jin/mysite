package com.ayjin.controller.view;

import com.ayjin.mapper.MessageMapper;
import com.ayjin.mapper.UserMapper;
import com.ayjin.pojo.Message;
import com.ayjin.pojo.User;
import com.ayjin.utils.getIp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class indexController {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/index")
    public String index(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        //分页
        PageHelper.startPage(pageNum,5);
        List<Message> messages = messageMapper.queryShowMessages();
        PageInfo<Message> pageInfo = new PageInfo<Message>(messages);
        model.addAttribute("pageInfo",pageInfo);
        //获得当前用户的Session
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            model.addAttribute("name",user.getName());
            model.addAttribute("email",user.getEmail());
            return "view/index";
        } catch (Exception e){
            model.addAttribute("name","");
            model.addAttribute("email","");
            return "view/index";
        }
    }

    @RequestMapping("/submsg")
    public String submsg(
            @RequestParam("username")String name,
            @RequestParam("email")String email,
            @RequestParam("title")String title,
            @RequestParam("message")String message,
            Model model,
            HttpServletRequest request
    ){
        String ipAddr = getIp.getIpAddr(request);
        Message savemsg = new Message();
        savemsg.setAuthor(name);
        savemsg.setEmail(email);
        savemsg.setTitle(title);
        savemsg.setContent(message);
        savemsg.setIp(ipAddr);
        messageMapper.addmsg(savemsg);
//        System.out.println("提交成功！");
        return "redirect:/index";
    }
    @RequestMapping("/subregi")
    public String subregi(
            @RequestParam("name")String name,
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            @RequestParam("email")String email
    ){
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userMapper.addUser(user);
        return "redirect:/index";
    }
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index";
    }
}
