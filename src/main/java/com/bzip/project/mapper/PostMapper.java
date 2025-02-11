package com.bzip.project.mapper;

import com.bzip.project.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(Post post);
    List<Post> selectPostByTitle(String title);
    List<Post> selectPostByNickname(String nickname);
    Post selectPostByUid (int uid);
    void updatePost(Post post);
    void deletePost(Post post);
}
