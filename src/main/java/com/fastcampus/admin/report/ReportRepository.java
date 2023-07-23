package com.fastcampus.admin.report;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportRepository {

    Report findById(Long id);

    List<Report> findAll();

    void deleteById(Long id);

    void deleteByBoardId(Long boardId);
}
