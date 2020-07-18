package com.ayjin.mapper;

import com.ayjin.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    List<Comment> queryAllComment();
    int delCom(int id);
}
