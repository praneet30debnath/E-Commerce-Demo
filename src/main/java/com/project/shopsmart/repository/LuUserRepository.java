package com.project.shopsmart.repository;

import com.project.shopsmart.model.LuUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface LuUserRepository extends JpaRepository<LuUser, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE LuUser u SET u.password = :newPassword WHERE u.userId = :userId")
    void changePassword(@Param("userId") Integer userId, @Param("newPassword") String newPassword);
}
