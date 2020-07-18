package com.ayjin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private int msgId;
    private String content;
    private String author;
    private String time;
    private String email;
    private String status;
}
