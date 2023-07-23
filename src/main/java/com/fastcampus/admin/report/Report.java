package com.fastcampus.admin.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Report {
    private Long id;
    private Long userId;
    private Long boardId;
    private String createdAt;
}