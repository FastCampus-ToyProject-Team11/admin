package com.fastcampus.admin.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
public class BoardRequest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class DeleteBoardDTO{
        private Long id;
        private boolean checkDelete;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class HideBoardDTO{
        private Long id;
        private boolean hide;
    }
}
