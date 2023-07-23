package com.fastcampus.admin.user;

import com.fastcampus.admin.user.dto.UserRequest;
import com.fastcampus.admin.user.dto.UserResponse;
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
@RequestMapping("/admin/user")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String user(Model model) {
        log.info("GET 회원 관리 페이지");
        List<UserResponse.GetUserDTO> getUserDTOList = userService.getAllUser();

        model.addAttribute("getUserDTOList", getUserDTOList);

        return "admin/user";
    }

    @PostMapping()
    public String user(@RequestBody UserRequest.SetRoleDTO setRoleDTO){
        log.info("POST 회원 관리 페이지");

        userService.setRole(setRoleDTO); //dto를 파라미터로 넘겨줘야함

        return "redirect:/admin";
    }
}
