package com.ayjin.controller.admin;

import com.ayjin.mapper.ViewerMapper;
import com.ayjin.pojo.Viewer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/viewers")
public class ViewerController {
    @Autowired
    ViewerMapper viewerMapper;

    @RequestMapping({"","/"})
    public String index(Model model){
        System.out.println("开始查询");
        List<Viewer> viewers = viewerMapper.queryAllViewers();
        model.addAttribute("viewers",viewers);
        return "redirect:/admin/viewers/list";
    }
    @RequestMapping("/list")
    // /admin/viewers/list?pageNum=1
    public String list(
            @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
            Model model
    ){
        PageHelper.startPage(pageNum,10);
        List<Viewer> viewers = viewerMapper.queryAllViewers();
        PageInfo<Viewer> pageInfo = new PageInfo<Viewer>(viewers);
        model.addAttribute("pageInfo",pageInfo);
//        //获得当前页数
//        int nowPage = pageInfo.getPageNum();
//        //获得总页数
//        int totalPage = pageInfo.getPages();
//        //获得下一页
//        int nextPage = pageInfo.getNextPage();
//        //获得上一页
//        int prePage = pageInfo.getPrePage();
//        //获得当页数据
//        pageInfo.getList();
//        model.addAttribute("nowPage",nowPage);
//        model.addAttribute("totalPage",totalPage);
//        model.addAttribute("nextPage",nextPage);
//        model.addAttribute("prePage",prePage);
        return "admin/viewerlist";
    }

}
