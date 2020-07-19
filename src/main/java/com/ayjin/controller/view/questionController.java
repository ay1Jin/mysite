package com.ayjin.controller.view;

import com.ayjin.mapper.QuestionMapper;
import com.ayjin.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class questionController {
    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping("/question")
    public String question(){
        return "view/question";
    }
    @RequestMapping("/subques")
    public String subques(
            @RequestParam("username")String name,
            @RequestParam("email")String email,
            @RequestParam("content")String content,
            Model model
    ){
        Question quesmsg = new Question();
        System.out.println(name);
        System.out.println(email);
        System.out.println(content);
        quesmsg.setName(name);
        quesmsg.setEmail(email);
        quesmsg.setContent(content);
        questionMapper.addQue(quesmsg);
        return "redirect:/index";
    }
}
