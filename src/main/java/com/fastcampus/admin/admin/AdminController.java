package com.fastcampus.admin.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public String main() {
        log.info("GET 메인 페이지");

        return "admin/main";
    }

    @PostMapping()
    public String main(Model model) {
        log.info("POST 메인 페이지");

        return "redirect:/admin";
    }
}
