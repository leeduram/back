package com.bzip.project.mapper;

import com.bzip.project.domain.Key;
import com.bzip.project.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeyMapper {
    void insertKey(Key key);
    Key selectKeyByUserUid(int uid);
}
