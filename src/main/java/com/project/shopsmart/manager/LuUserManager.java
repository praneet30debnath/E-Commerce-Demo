package com.project.shopsmart.manager;

import java.util.Date;

public interface LuUserManager {
    public String updatePassword(Integer userId, String newPassword, Date updateTime);

    public Boolean isAuthSuccessful(String emailId, String password);
}
