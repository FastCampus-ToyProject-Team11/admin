package com.fastcampus.admin.user.dto;

import com.fastcampus.admin.user.Role;
import lombok.*;

public class UserRequest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class SetRoleDTO{
        private Long id;
        private Role role;
    }
}
