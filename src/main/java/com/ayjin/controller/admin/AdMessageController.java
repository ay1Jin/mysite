package com.ayjin.controller.admin;

import com.ayjin.mapper.MessageMapper;
import com.ayjin.mapper.ViewerMapper;
import com.ayjin.pojo.Message;
import com.ayjin.pojo.Viewer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/messages")
public class AdMessageController {
    @Autowired
    MessageMapper messageMapper;

    @RequestMapping({"","/"})
    public String index(Model model){
        System.out.println("开始查询");
        return "redirect:/admin/messages/list";
    }
    @RequestMapping("/list")
    // /admin/messages/list?pageNum=1
    public String list(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        PageHelper.startPage(pageNum,5);
        List<Message> messages = messageMapper.queryAllMessages();
        PageInfo<Message> pageInfo = new PageInfo<Message>(messages);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "admin/messagelist";
    }
    @GetMapping("/delmsg/{id}")
    public String delmsg(
            @PathVariable("id")Integer id
    ){
        messageMapper.delmsg(id);
        return "redirect:/admin/messages/list";
    }
}
