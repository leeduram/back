package com.bzip.project.mapper;

import com.bzip.project.domain.Game;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapper {
    Game selectGameByUid(int uid);
}
