package com.project.shopsmart.dao;

import java.util.Date;

public interface LuUserDao {
    public String updatePassword(Integer userId, String newPassword, Date updateTime);

    public Boolean isAuthSuccessful(String emailId, String password);
}
