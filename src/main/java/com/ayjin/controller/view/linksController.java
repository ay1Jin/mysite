package com.ayjin.controller.view;

import com.ayjin.mapper.LinkMapper;
import com.ayjin.pojo.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class linksController {
    @Autowired
    LinkMapper linkMapper;

    @RequestMapping("/links")
    public String links(Model model){
        List<Link> linkList = linkMapper.queryAllShowLinks();
        model.addAttribute(linkList);
        return "view/links";
    }
    @RequestMapping("/subLink")
    public String subLink(
            @RequestParam("name")String name,
            @RequestParam("email")String email,
            @RequestParam("link")String link

    ){
        Link linkmsg = new Link();
        linkmsg.setEmail(email);
        linkmsg.setLink(link);
        linkmsg.setUsername(name);
        linkMapper.addLink(linkmsg);
//        System.out.println("添加成功，请审核！");
        return "redirect:/links";
    }
}
