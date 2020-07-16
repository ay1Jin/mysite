package com.ayjin.mapper;

import com.ayjin.pojo.Viewer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ViewerMapper {
    List<Viewer> queryAllViewers();
    int addViewers(String ip);
}
