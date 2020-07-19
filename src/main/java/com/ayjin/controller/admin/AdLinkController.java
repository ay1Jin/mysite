package com.ayjin.controller.admin;

import com.ayjin.mapper.LinkMapper;
import com.ayjin.mapper.MessageMapper;
import com.ayjin.pojo.Link;
import com.ayjin.pojo.Message;
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
@RequestMapping("/admin/links")
public class AdLinkController {
    @Autowired
    LinkMapper linkMapper;

    @RequestMapping({"","/"})
    public String index(Model model){
//        System.out.println("开始查询");
        return "redirect:/admin/links/list";
    }
    @RequestMapping("/list")
    // /admin/messages/list?pageNum=1
    public String list(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        PageHelper.startPage(pageNum,5);
        List<Link> links = linkMapper.queryAllLinks();
        PageInfo<Link> pageInfo = new PageInfo<Link>(links);
        model.addAttribute("pageInfo",pageInfo);
//        System.out.println(pageInfo);
        return "admin/linklist";
    }

    @GetMapping("/addlink/{id}")
    public String addLink(
            @PathVariable("id")Integer id
    ){
        linkMapper.sucLink(id);
        return "redirect:/admin/links/list";
    }

    @GetMapping("/dellink/{id}")
    public String delLink(
            @PathVariable("id")Integer id
    ){
        linkMapper.delLink(id);
        return "redirect:/admin/links/list";
    }
}
