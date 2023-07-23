package com.fastcampus.admin.board;

import com.fastcampus.admin.board.dto.BoardRequest;
import com.fastcampus.admin.board.dto.BoardResponse;
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
@RequestMapping("/admin/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public String board(Model model) {
        log.info("GET 게시글 관리 페이지");
        List<BoardResponse.GetBoardDTO> getBoardDTOList = boardService.getAllBoard();

        model.addAttribute("getBoardDTOList", getBoardDTOList);

        return "admin/board";
    }

    @PostMapping()
    public String board(@RequestBody BoardRequest.DeleteBoardDTO deleteBoardDTO,
                        @RequestBody BoardRequest.HideBoardDTO hideBoardDTO) {
        log.info("POST 게시글 관리 페이지");

        //삭제
        if(deleteBoardDTO.isCheckDelete()){
            boardService.deleteBoard(deleteBoardDTO);
            return "redirect:/admin";
        }

        //숨기기
        boardService.hideBoard(hideBoardDTO);
        return "redirect:/admin";
    }
}
