package com.fastcampus.admin.user;

import com.fastcampus.admin.report.Reason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

     User findById(Long id);

     List<User> findAll();

     void updateById(@Param("id") Long id, @Param("role") Role role);

     void updateReasonById(@Param("id") Long id, @Param("black") boolean black, @Param("reason") Reason reason);
}
