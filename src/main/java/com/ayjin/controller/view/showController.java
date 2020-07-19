package com.ayjin.controller.view;

import com.ayjin.mapper.ViewerMapper;
import com.ayjin.utils.getIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class showController {
    @Autowired
    ViewerMapper viewerMapper;
    @RequestMapping("")
    public String show(HttpServletRequest request){
        String ipAddr = getIp.getIpAddr(request);
//        System.out.println(ipAddr);
        viewerMapper.addViewers(ipAddr);
//        System.out.println("成功添加！");
        return "view/view";
    }
}
