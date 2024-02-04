package com.project.shopsmart.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.project.shopsmart.dao.LuUserDao;
import com.project.shopsmart.model.LuUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class LuUserDaoImpl implements LuUserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public String updatePassword(Integer userId, String newPassword, Date updateTime) {
        try {
            String hqlQuery = "UPDATE LuUser u SET u.password = :newPassword, u.updateTime = :updateTime WHERE u.userId = :userId";
            Query query = entityManager.createQuery(hqlQuery);
            query.setParameter("newPassword", newPassword);
            query.setParameter("updateTime", updateTime);
            query.setParameter("userId", userId);
            Integer count = query.executeUpdate();
            return "Password Changed Successfully";
        } catch (Exception e) {
            return "Some error occured while changing password";
        }
    }

    @Override
    public Boolean isAuthSuccessful(String emailId, String password) {
        Boolean success = false;
        try {
            String hqlQuery = "FROM LuUser WHERE emailId = :emailId";
            Query query = entityManager.createQuery(hqlQuery);
            query.setParameter("emailId", emailId);
            List<LuUser> luUser = (List<LuUser>) query.getResultList();
            String passwordFromDB = luUser.size() > 0 ? luUser.get(0).getPassword() : null;
            System.out.println("PASSWORD IS ==================> " + passwordFromDB);
            if(passwordFromDB != null) {
                success = passwordFromDB.equals(password);
            }
            return success;
        } catch (Exception e) {
            return success;
        }
    }
}
