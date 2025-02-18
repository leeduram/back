package com.bzip.project.domain;

import java.time.LocalDateTime;

public class User {
    private int uid;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private LocalDateTime signupDate;
    private String auth;
    private String accountStatus;
    private boolean downloadPermission;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDateTime signupDate) {
        this.signupDate = signupDate;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public boolean isDownloadPermission() {
        return downloadPermission;
    }

    public void setDownloadPermission(boolean downloadPermission) {
        this.downloadPermission = downloadPermission;
    }

}
