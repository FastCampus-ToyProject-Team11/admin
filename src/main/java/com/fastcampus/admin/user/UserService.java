package com.fastcampus.admin.user;

import com.fastcampus.admin.board.BoardRepository;
import com.fastcampus.admin.comment.CommentRepository;
import com.fastcampus.admin.user.dto.UserRequest;
import com.fastcampus.admin.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void setRole(UserRequest.SetRoleDTO setRoleDTO){
        userRepository.updateById(setRoleDTO.getId(), setRoleDTO.getRole());
    }

    @Transactional
    public List<UserResponse.GetUserDTO> getAllUser(){
        List<User> users = userRepository.findAll();
        List<UserResponse.GetUserDTO> GetUserDTOList = new ArrayList<>();
        for (User user : users) {
            GetUserDTOList.add(UserResponse.GetUserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .nickName(user.getNickName())
                    .email(user.getEmail())
                    .commentCount(commentRepository.findByUserId(user.getId()))
                    .boardCount(boardRepository.findByUserId(user.getId())).build());
        }

        return GetUserDTOList;
    }
}
