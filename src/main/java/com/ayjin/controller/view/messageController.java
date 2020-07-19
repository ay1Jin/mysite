package com.ayjin.controller.view;

import com.ayjin.mapper.CommentMapper;
import com.ayjin.mapper.MessageMapper;
import com.ayjin.pojo.Comment;
import com.ayjin.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class messageController {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    CommentMapper commentMapper;
    @RequestMapping("/message/{id}")
    public String message(
            @PathVariable("id")Integer id,
            Model model
    ){
        //获得文章内容
        Message message = messageMapper.queryMsgById(id);
        //获得文章评论
        List<Comment> comments = commentMapper.queryCommentById(id);
        model.addAttribute("messages",message);
        model.addAttribute("comments",comments);
        return "view/message";
    }
    @RequestMapping("/subCom/{id}")
    public String comment(
            @PathVariable("id")Integer id,
            @RequestParam("comment")String content,
            @RequestParam("username")String username,
            @RequestParam("email")String email
    ){
        Comment comment = new Comment();
        comment.setAuthor(username);
        comment.setContent(content);
        comment.setEmail(email);
        comment.setMsgId(id);
        commentMapper.addCom(comment);
//        System.out.println("提交成功！");
        return "redirect:/message/{id}";
    }
}
