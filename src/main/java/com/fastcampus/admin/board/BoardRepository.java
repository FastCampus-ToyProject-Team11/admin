package com.fastcampus.admin.board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BoardRepository {
    //보드
    Board findById(Long id);

    List<Board> findAll();

    int deleteById(@Param("id") long id);

    int updateById(@Param("id") Long id, @Param("hide") boolean hide, @Param("state") State state);

    int updateStateByBoardId(@Param("boardId") Long boardId, @Param("state") State state);

    int insert(Long id);

    Long findByUserId(Long userId);
}
