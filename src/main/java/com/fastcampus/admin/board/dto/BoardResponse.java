package com.fastcampus.admin.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class BoardResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class GetBoardDTO{
        private Long id;
        private String title;
        private String content;
        private Long userId;
        private Long boardId;
        private String username;
        private String createdAt;
        private String updatedAt;
        private boolean reported;
    }
}
