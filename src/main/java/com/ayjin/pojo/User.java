package com.ayjin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String status;
    private String rights;
    private String email;
    private String time;
    private String name;
}
