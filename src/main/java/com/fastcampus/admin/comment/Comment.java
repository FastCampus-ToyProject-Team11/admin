package com.fastcampus.admin.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Comment {

    private Long id;
    private String content;
    private Long userId;
    private Long boardId;
    private Long depth;
    private Long commentGroup;

    protected void onCreate() {
        depth = 0L;
    }
}
