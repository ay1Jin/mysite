package com.ayjin.controller.view;

import com.ayjin.mapper.MessageMapper;
import com.ayjin.pojo.Message;
import com.ayjin.utils.getIp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @RequestMapping("/index")
    public String index(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        PageHelper.startPage(pageNum,5);
        List<Message> messages = messageMapper.queryShowMessages();
        PageInfo<Message> pageInfo = new PageInfo<Message>(messages);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "view/index";
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
        System.out.println("提交成功！");
        return "redirect:/index";
    }
}
