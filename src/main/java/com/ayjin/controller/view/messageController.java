package com.ayjin.controller.view;

import com.ayjin.mapper.MessageMapper;
import com.ayjin.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class messageController {
    @Autowired
    MessageMapper messageMapper;
    @RequestMapping("/message/{id}")
    public String message(
            @PathVariable("id")Integer id,
            Model model
    ){
        Message message = messageMapper.queryMsgById(id);
        model.addAttribute(message);
        return "view/message";
    }
}
