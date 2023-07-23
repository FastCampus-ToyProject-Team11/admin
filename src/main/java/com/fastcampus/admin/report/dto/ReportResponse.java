package com.fastcampus.admin.report.dto;

import com.fastcampus.admin.board.State;
import com.fastcampus.admin.report.Reason;
import com.fastcampus.admin.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReportResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class GetReportDTO{
        private Long id;
        private Long userId;
        private Long boardId;
        private String createdAt;

        private String title;
        private String content;

        private String username;
        private Role role;
        private State state;
        private boolean black;
        private Reason reason;
    }
}
