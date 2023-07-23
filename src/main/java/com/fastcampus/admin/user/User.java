package com.fastcampus.admin.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String nickName;
    private Role role;
    private String createdAt;
    private String updatedAt;
    private boolean black;

    protected void onCreate() {
        role = Role.SESAC;
    }
}
