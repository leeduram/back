package com.bzip.project.service;

import com.bzip.project.domain.Post;
import com.bzip.project.domain.User;
import com.bzip.project.dto.PostPaginationResponseDTO;
import com.bzip.project.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostMapper postMapper;

    @Autowired
    public PostService(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    public void savePost (Post post) throws Exception {
        if (post.getTitle() == null || post.getContent() == null){
            throw new Exception();
        }
        postMapper.insertPost(post);
    }

    public void modifyPost(Post post, User user) throws Exception {
        Post selectedPost = postMapper.selectPostByUid(post.getUid());
        if (selectedPost == null){
            throw new Exception("게시글을 찾을 수 없습니다.");
        }

        if (selectedPost.getUser().getUid() != user.getUid()){
            throw new Exception("작성자만 게시글을 수정할 수 잇습니다.");
        }
        postMapper.updatePost(post);
    }

    public void modifyDeleteyn(Post post, User user) throws Exception {
        Post selectedPost = postMapper.selectPostByUid(post.getUid());
        if (selectedPost == null){
            throw new Exception("게시글을 찾을 수 없습니다.");
        }
        
        if (selectedPost.getUser().getUid() != user.getUid()){
            throw new Exception("작성자만 게시글을 삭제할 수 잇습니다.");
        }
        postMapper.deletePost(post);
    }

    public PostPaginationResponseDTO getPagedPosts (int page, int limit) {
        int offset = (page - 1) * limit;
        List<Post> posts = postMapper.selectPostsWithPagination(limit, offset);
        long totalPosts = postMapper.countPosts(); // 전체 게시글 수 가져오기

        return new PostPaginationResponseDTO(totalPosts, posts);
    }

    public long getTotalPosts() {
        return postMapper.countPosts();
    }

    public Post getPostDataForView(int uid) throws Exception {
        Post post = postMapper.selectPostByUid(uid);
        if (post == null) {
            throw new Exception("게시글을 찾을 수 없습니다.");
        }

        if ("y".equals(post.getDeleteyn())) {
            throw new Exception("이미 삭제된 게시글입니다.");
        }

        return post;
    }
}
