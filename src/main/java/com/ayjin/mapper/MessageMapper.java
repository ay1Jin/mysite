package com.ayjin.mapper;

import com.ayjin.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    List<Message> queryAllMessages();
    List<Message> queryShowMessages();
    Message queryMsgById(int id);
    int delmsg(int id);
    int addmsg(Message message);
}
