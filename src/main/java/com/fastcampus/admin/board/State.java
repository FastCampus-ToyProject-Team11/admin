package com.fastcampus.admin.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {
    DEFAULT,
    REPORT,
    DELETE

//    DEFAULT("기본"),
//    HIDE("숨기기"),
//    REPORT("신고"),
//    DELETE("삭제");
//
//    private final String value;
}
