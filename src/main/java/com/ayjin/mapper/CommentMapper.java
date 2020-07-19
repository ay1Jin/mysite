package com.ayjin.mapper;

import com.ayjin.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    List<Comment> queryAllComment();
    List<Comment> queryCommentById(int id);
    int delCom(int id);
    int addCom(Comment comment);
}
