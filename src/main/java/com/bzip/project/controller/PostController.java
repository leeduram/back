package com.bzip.project.controller;

import com.bzip.project.domain.Post;
import com.bzip.project.domain.User;
import com.bzip.project.dto.*;
import com.bzip.project.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/post")
    public ResponseEntity<?> write(@RequestBody RequestPostDTO requestPostDTO,
                                   HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = new User();
        user.setUid((int) session.getAttribute("userUid"));
        Post post = new Post();
        post.setTitle(requestPostDTO.getTitle());
        post.setContent(requestPostDTO.getContent());
        post.setUser(user);

        try {
            postService.savePost(post);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/api/title")
    public ResponseEntity<?> searchByTitle(@RequestBody RequestTitleDTO requestTitleDTO) {
        try {
            List<Post> post = postService.findPostByTitle(requestTitleDTO);
            return ResponseEntity.status(HttpStatus.OK).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/api/nickname")
    public ResponseEntity<?> searchByNickname(@RequestBody RequestNicknameDTO requestNicknameDTO) {
        try {
            List<Post> post = postService.findPostByNickname(requestNicknameDTO);
            return ResponseEntity.status(HttpStatus.OK).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/api/update")
    public ResponseEntity<?> modify(@RequestBody RequestUpdateDTO requestUpdateDTO,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = new User();
        user.setUid((int) session.getAttribute("userUid"));
        Post post = new Post();
        post.setUid(requestUpdateDTO.getUid());
        post.setTitle(requestUpdateDTO.getTitle());
        post.setContent(requestUpdateDTO.getContent());
        post.setUser(user);

        try {
            postService.modifyPost(post, user);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            if (e.getMessage().equals("게시글을 찾을 수 없습니다.")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else if (e.getMessage().equals("작성자만 게시글을 수정할 수 잇습니다.")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/api/delete")
    public ResponseEntity<?> delete(@RequestBody RequestDeleteDTO requestDeleteDTO,
                                    HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = new User();
        user.setUid((int) session.getAttribute("userUid"));
        Post post = new Post();
        post.setUid(requestDeleteDTO.getUid());
        try {
            postService.modifyDeleteyn(post, user);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            if (e.getMessage().equals("게시글을 찾을 수 없습니다.")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else if (e.getMessage().equals("작성자만 게시글을 삭제할 수 잇습니다.")){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
