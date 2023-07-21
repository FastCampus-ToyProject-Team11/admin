package com.fastcampus.admin.user;

import com.fastcampus.admin.user.dto.UserRequestDTO;
import com.fastcampus.admin.user.dto.UserResponseDTO;
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
        List<UserResponseDTO> userResponseDTOList = userService.getAllUser();

//        if(userResponseDTOList.size() == 0)
//            ;//todo

        model.addAttribute("userResponseDTOList", userResponseDTOList);

        return "admin/user";
    }

    @PostMapping()
    public String user(@RequestBody UserRequestDTO userRequestDTO){
        log.info("POST 회원 관리 페이지");

        userService.setRole(userRequestDTO); //dto를 파라미터로 넘겨줘야함

        return "redirect:/admin";
    }

}
