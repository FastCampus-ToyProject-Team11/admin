package com.fastcampus.admin.report;

import com.fastcampus.admin.report.dto.ReportRequestDTO;
import com.fastcampus.admin.report.dto.ReportResponseDTO;
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
        List<ReportResponseDTO> reportResponseDTOList = reportService.getAllReport();

        //if(reportResponseDTOList.size() == 0)

        model.addAttribute("reportResponseDTOList", reportResponseDTOList);

        return "admin/report";
    }

    @PostMapping()
    public String report(@RequestBody ReportRequestDTO.UpdateRoleDTO updateRoleDTO) {
        log.info("POST 신고게시글 관리 페이지");

        reportService.updateRole(updateRoleDTO);
        //reportService.deleteRportedBoard(updateRoleDTO);
        return "redirect:/admin";
    }
}
