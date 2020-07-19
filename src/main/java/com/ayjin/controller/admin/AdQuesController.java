package com.ayjin.controller.admin;

import com.ayjin.mapper.QuestionMapper;
import com.ayjin.pojo.Comment;
import com.ayjin.pojo.Question;
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
@RequestMapping("/admin/questions")
public class AdQuesController {
    @Autowired
    QuestionMapper questionMapper;
    @RequestMapping({"","/"})
    public String index(Model model){
        return "redirect:/admin/questions/list";
    }
    @RequestMapping("/list")
    public String list(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        PageHelper.startPage(pageNum,5);
        List<Question> questions = questionMapper.queryQuestions();
        PageInfo<Question> pageInfo = new PageInfo<Question>(questions);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "admin/questionlist";
    }
}
