package com.bzip.project.controller;

import com.bzip.project.domain.User;
import com.bzip.project.dto.RequestLoginDTO;
import com.bzip.project.dto.RequestSignupDTO;
import com.bzip.project.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/allData")
    public List<User> getData() {
        return userService.getAllUserData();
    }

    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody RequestSignupDTO requestSignupDTO) {
        User user = new User();
        user.setEmail(requestSignupDTO.getEmail());
        user.setPassword(requestSignupDTO.getPassword());
        user.setName(requestSignupDTO.getName());
        user.setNickname(requestSignupDTO.getNickname());

        try {
            userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody RequestLoginDTO requestLoginDTO,
                                   HttpServletRequest request) {
        User user = new User();
        user.setEmail(requestLoginDTO.getEmail());
        user.setPassword(requestLoginDTO.getPassword());

        try {
            User findUser = userService.login(user);
            HttpSession session = request.getSession();
            session.setAttribute("userUid", findUser.getUid());
            session.setAttribute("auth", findUser.getAuth());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
