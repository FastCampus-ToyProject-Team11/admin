package com.fastcampus.admin.report;

import com.fastcampus.admin.report.dto.ReportRequest;
import com.fastcampus.admin.report.dto.ReportResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/admin/report")
@RequiredArgsConstructor
@Controller
public class ReportController {

    private final ReportService reportService;

    @GetMapping()
    public String report(Model model){
        log.info("GET 신고게시글 관리 페이지");

        List<ReportResponse.GetReportDTO> getReportDTOList = reportService.getAllReport();
        model.addAttribute("getReportDTOList", getReportDTOList);
        return "admin/report";
    }

    @PostMapping()
    public String report(@RequestBody ReportRequest.SetBlackDTO setBlackDTO) {
        log.info("POST 신고게시글 관리 페이지");

        //reportService.setBlack(setBlackDTO); //데이터베이스 필드 없음.
        return "redirect:/admin/report";
    }
}
