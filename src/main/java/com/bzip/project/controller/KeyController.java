package com.bzip.project.controller;

import com.bzip.project.domain.Game;
import com.bzip.project.domain.Key;
import com.bzip.project.domain.User;
import com.bzip.project.dto.GameDTO;
import com.bzip.project.dto.KeyDTO;
import com.bzip.project.service.GameService;
import com.bzip.project.service.KeyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
    private KeyService keyService;
    private GameService gameService;

    @Autowired
    public KeyController(KeyService keyService, GameService gameService) {
        this.keyService = keyService;
        this.gameService = gameService;
    }

    @PostMapping("/api/key")
    public void save(@RequestBody KeyDTO keyDTO,
                    HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = new User();
        user.setUid((int) session.getAttribute("userUid"));
        Game game = keyDTO.getGame();
        GameDTO gameDTO = new GameDTO();
        gameDTO.setUid(game.getUid());
        Game gameByUid = gameService.getGameByUid(gameDTO);
        Key key = new Key();
        key.setUser(user);
        key.setGame(gameByUid);
        key.setMethod(keyDTO.getMethod());

        keyService.saveKey(key);
    }

    @PostMapping("/api/donate")
    public Key donate(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = new User();
        user.setUid((int) session.getAttribute("userUid"));
        Key keyData = keyService.getKeyData(user);

        return keyData;
    }
}
