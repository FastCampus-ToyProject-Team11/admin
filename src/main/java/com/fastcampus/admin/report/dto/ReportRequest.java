package com.fastcampus.admin.report.dto;

import com.fastcampus.admin.report.Reason;
import lombok.*;


public class ReportRequest {

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Getter
    @Builder
    public static class SetBlackDTO {
        private Long id;
        //private State state;

        private Reason reason;
        private Long boardId;
        private boolean black;
    }
}
