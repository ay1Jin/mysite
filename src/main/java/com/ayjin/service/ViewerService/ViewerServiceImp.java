package com.ayjin.service.ViewerService;

import com.ayjin.mapper.ViewerMapper;
import com.ayjin.pojo.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerServiceImp implements ViewerService{
    @Autowired
    ViewerMapper viewerMapper;

    @Override
    public List<Viewer> queryAllViewers() {
        return viewerMapper.queryAllViewers();
    }
}
