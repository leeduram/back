package com.bzip.project.dto;

import com.bzip.project.domain.Game;
import com.bzip.project.domain.User;

public class KeyDTO {
    private User user;
    private Game game;
    private String method;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
