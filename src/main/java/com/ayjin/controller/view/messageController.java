package com.ayjin.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class messageController {
    @RequestMapping("/message")
    public String message(){
        return "view/message";
    }
}
