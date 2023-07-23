package com.fastcampus.admin.user;

import com.fastcampus.admin._core.errors.esception.Exception500;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum Role {
    SESAC,
    EXCELLENT;

    public static Role from(String name) {
        for (Role role : Role.values()) {
            if (Objects.equals(role.name(), name)) return role;
        }
        throw new Exception500("권한 매칭 오류");
    }
}
