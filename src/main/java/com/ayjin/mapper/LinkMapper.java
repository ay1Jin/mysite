package com.ayjin.mapper;

import com.ayjin.pojo.Link;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LinkMapper {
    List<Link> queryAllLinks();
    List<Link> queryAllShowLinks();
    int addLink(Link link);
    int sucLink(int id);
    int delLink(int id);
}
