package com.ayjin.service.MessageService;

import com.ayjin.mapper.MessageMapper;
import com.ayjin.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageServiceImp implements MessageService{
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> queryAllMessages() {
        return messageMapper.queryAllMessages();
    }
}
