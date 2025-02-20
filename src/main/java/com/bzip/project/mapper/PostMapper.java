package com.bzip.project.mapper;

import com.bzip.project.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(Post post);
    Post selectPostByUid (int uid);
    void updatePost(Post post);
    void deletePost(Post post);

    List<Post> selectPostsWithPagination(@Param("limit") int limit, @Param("offset") int offset); //페이징 처리된 게시글 목록을 가져오는 메서드
    long countPosts(); //전체 게시글 수를 구하는 메서드
}
