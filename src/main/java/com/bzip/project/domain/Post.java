package com.bzip.project.domain;

import java.time.LocalDateTime;

public class Post {
    private int uid;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private User user;
    private String deleteyn;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(LocalDateTime writeDate) {
        this.writeDate = writeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeleteyn() {
        return deleteyn;
    }

    public void setDeleteyn(String deleteyn) {
        this.deleteyn = deleteyn;
    }
}
