package com.fastcampus.admin.user.dto;

import com.fastcampus.admin.user.Role;
import lombok.*;


public class UserResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class GetUserDTO{
        private Long id;

        private String username;

        private String email;

        private String nickName;

        private Role role;

        private Long commentCount;
        private Long boardCount;
    }
}
