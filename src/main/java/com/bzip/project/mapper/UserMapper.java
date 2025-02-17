package com.bzip.project.mapper;

import com.bzip.project.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User selectEmail (String email);
    List<User> selectAll();
    User selectUserByUid(int uid);
    void updateUser(User user);
}
