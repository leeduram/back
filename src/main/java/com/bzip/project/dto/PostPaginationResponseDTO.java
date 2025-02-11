package com.bzip.project.dto;

import com.bzip.project.domain.Post;

import java.util.List;

public class PostPaginationResponseDTO {
    private long totalPosts; // 총 게시글 수
    private List<Post> posts; // 현재 페이지에 해당하는 게시글 목록

    public PostPaginationResponseDTO(long totalPosts, List<Post> posts){
        this.totalPosts = totalPosts;
        this.posts = posts;
    }

    public long getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(long totalPosts) {
        this.totalPosts = totalPosts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
