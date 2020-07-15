package com.ayjin.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class linksController {
    @RequestMapping("/links")
    public String links(){
        return "view/links";
    }
}
