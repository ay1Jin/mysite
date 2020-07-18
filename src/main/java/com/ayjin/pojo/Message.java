package com.ayjin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private String author;
    private String title;
    private String ip;
    private String email;
    private String content;
    private String time;
    private int likeCount;
    private int comCount;
    private String status;
}
