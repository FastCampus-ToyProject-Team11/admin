package com.fastcampus.admin.report;

import com.fastcampus.admin.board.Board;
import com.fastcampus.admin.board.BoardRepository;
import com.fastcampus.admin.report.dto.ReportRequest;
import com.fastcampus.admin.report.dto.ReportResponse;
import com.fastcampus.admin.user.User;
import com.fastcampus.admin.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<ReportResponse.GetReportDTO> getAllReport() {
        ArrayList<Report> reportList = new ArrayList<>(reportRepository.findAll());

        List<ReportResponse.GetReportDTO> getReportDTOList = new ArrayList<>();

        if(reportList == null)
            return getReportDTOList;

        for (Report report : reportList) {
            Board board = boardRepository.findById(report.getBoardId());
            User user = userRepository.findById(report.getUserId());

            getReportDTOList.add(ReportResponse.GetReportDTO.builder()
                    .id(report.getId())
                    .userId(report.getUserId())
                    .boardId(report.getBoardId())
                    .createdAt(report.getCreatedAt())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .build());
        }

        return getReportDTOList;
    }

    @Transactional
    public void setBlack(ReportRequest.SetBlackDTO setBlackDTO){
        userRepository.updateReasonById(setBlackDTO.getId(), setBlackDTO.isBlack(), setBlackDTO.getReason());
    }

}
