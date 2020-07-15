package com.ayjin.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {
    @RequestMapping("")
    public String admin(){
        return "admin/index";
    }
    @RequestMapping("/viewers")
    public String viewers(){
        return "admin/viewers";
    }
    @RequestMapping("/messages")
    public String messages(){
        return "admin/messages";
    }
    @RequestMapping("/users")
    public String users(){
        return "admin/users";
    }
    @RequestMapping("/links")
    public String links(){
        return "admin/links";
    }
}
