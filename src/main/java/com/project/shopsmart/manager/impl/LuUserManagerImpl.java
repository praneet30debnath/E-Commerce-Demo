package com.project.shopsmart.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopsmart.dao.LuUserDao;
import com.project.shopsmart.manager.LuUserManager;

@Service
public class LuUserManagerImpl implements LuUserManager {
    private LuUserDao luUserDao;

    @Autowired
    public LuUserManagerImpl(LuUserDao luUserDao) {
        this.luUserDao = luUserDao;
    }

    @Override
    public String updatePassword(Integer userId, String newPassword, Date updateTime) {
        return luUserDao.updatePassword(userId, newPassword, updateTime);
    }

    @Override
    public Boolean isAuthSuccessful(String emailId, String password) {
        return luUserDao.isAuthSuccessful(emailId, password);
    }
}
