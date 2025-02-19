package com.bzip.project.service;

import com.bzip.project.domain.Game;
import com.bzip.project.dto.GameDTO;
import com.bzip.project.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameMapper gameMapper;

    @Autowired
    public GameService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    public Game getGameByUid (GameDTO gameDTO) {
        Game game = gameMapper.selectGameByUid(gameDTO.getUid());

        return game;
    }
}
