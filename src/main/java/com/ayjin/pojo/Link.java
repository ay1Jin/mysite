package com.ayjin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private int id;
    private String username;
    private String email;
    private String link;
    private String status;
}
