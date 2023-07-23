package com.fastcampus.admin.board;

import com.fastcampus.admin.board.dto.BoardRequest;
import com.fastcampus.admin.board.dto.BoardResponse;
import com.fastcampus.admin.comment.CommentRepository;
import com.fastcampus.admin.report.ReportRepository;
import com.fastcampus.admin.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;

    public BoardResponse.GetBoardDTO getBoard(Long id) {
        Board board = boardRepository.findById(id);

        return BoardResponse.GetBoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .userId(board.getUserId())
                .username(userRepository.findById(board.getUserId()).getUsername())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    @Transactional(readOnly = true)
    public List<BoardResponse.GetBoardDTO> getAllBoard() {
        ArrayList<Board> boards = new ArrayList<>(boardRepository.findAll());
        List<BoardResponse.GetBoardDTO> GetBoardDTOList = new ArrayList<>();

        for (Board board : boards) {
            GetBoardDTOList.add(BoardResponse.GetBoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .userId(board.getUserId())
                    .username(userRepository.findById(board.getUserId()).getUsername())
                    .createdAt(board.getCreatedAt())
                    .updatedAt(board.getUpdatedAt())
                    .build());
        }

        return GetBoardDTOList;
    }

    @Transactional
    public void deleteBoard(BoardRequest.DeleteBoardDTO deleteBoardDTO){
        commentRepository.deleteByBoardId(deleteBoardDTO.getId());
        reportRepository.deleteByBoardId(deleteBoardDTO.getId());
        boardRepository.deleteById(deleteBoardDTO.getId());
    }

    @Transactional
    public void hideBoard(BoardRequest.HideBoardDTO hideBoardDTO){ //숨기기, 보이기 따로 하던지, 변수 받아서 처리 하던지
        boardRepository.updateHideById(hideBoardDTO.getId(), hideBoardDTO.isHide());
    }

}

