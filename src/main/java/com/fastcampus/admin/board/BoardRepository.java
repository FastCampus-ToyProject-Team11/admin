package com.fastcampus.admin.board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardRepository {
    //보드
    Board findById(Long id);

    List<Board> findAll();

    void deleteById(Long id);

    void updateHideById(@Param("id")Long id, @Param("hide")boolean hide);

    Long findByUserId(Long userId);

    void deleteByReportedId(@Param("boardId")Long boardId);
}
