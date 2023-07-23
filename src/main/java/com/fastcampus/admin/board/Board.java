package com.fastcampus.admin.board;

import com.fastcampus.admin.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Board {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String createdAt;
    private String updatedAt;

    private Role role;
    private boolean hide;

}
