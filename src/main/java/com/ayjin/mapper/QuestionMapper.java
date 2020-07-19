package com.ayjin.mapper;

import com.ayjin.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
    List<Question> queryQuestions();
    int addQue(Question question);
}
