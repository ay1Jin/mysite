package com.ayjin.controller.admin;

import com.ayjin.mapper.CommentMapper;
import com.ayjin.mapper.MessageMapper;
import com.ayjin.pojo.Comment;
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
@RequestMapping("/admin/users")
public class AdUserController {
    @Autowired
    CommentMapper commentMapper;

    @RequestMapping({"","/"})
    public String index(Model model){
        System.out.println("开始查询");
        return "redirect:/admin/users/list";
    }
    @RequestMapping("/list")
    public String list(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        PageHelper.startPage(pageNum,5);
        List<Comment> comments = commentMapper.queryAllComment();
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "admin/userlist";
    }
    @GetMapping("/delmsg/{id}")
    public String delmsg(
            @PathVariable("id")Integer id
    ){
        commentMapper.delCom(id);
        return "redirect:/admin/users/list";
    }
}
