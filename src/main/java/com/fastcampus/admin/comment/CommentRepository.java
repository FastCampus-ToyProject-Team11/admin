package com.fastcampus.admin.comment;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentRepository {

    Long findByUserId(Long userId);

    Long findByBoardId(Long boardId);

    void deleteByBoardId(Long boardId);
}
