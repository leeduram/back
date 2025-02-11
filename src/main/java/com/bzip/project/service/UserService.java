package com.bzip.project.service;

import com.bzip.project.domain.User;
import com.bzip.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public List<User> getAllUserData(){
        return userMapper.selectAll();
    }

    public void saveUser(User user) throws Exception {
        User findUser = userMapper.selectEmail(user.getEmail());
        if (findUser != null){
            throw new Exception();
        }
        userMapper.insertUser(user);
    }

    public User login (User user) throws Exception {
        User findUser = userMapper.selectEmail(user.getEmail());
        if(findUser != null && user.getPassword().equals(findUser.getPassword())){
            return findUser;
        }else {
            throw new Exception();
        }
    }
}
