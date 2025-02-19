package com.bzip.project.service;

import com.bzip.project.domain.Key;
import com.bzip.project.domain.User;
import com.bzip.project.mapper.KeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    private KeyMapper keyMapper;

    @Autowired
    public KeyService(KeyMapper keyMapper) {
        this.keyMapper = keyMapper;
    }

    public void saveKey (Key key) {
        keyMapper.insertKey(key);
    }

    public Key getKeyData (User user) {
        Key key = keyMapper.selectKeyByUserUid(user);
        return key;
    }
}
