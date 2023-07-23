package com.fastcampus.admin.comment.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class CommentResponse {

    private Long id;
    private String content;
    private Long userId;
    private Long boardId;
    private Long depth;
    private Long commentGroup;

}
