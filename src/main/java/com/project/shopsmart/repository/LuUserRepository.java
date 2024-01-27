package com.project.shopsmart.repository;

import com.project.shopsmart.model.LuUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface LuUserRepository extends JpaRepository<LuUser, Integer> {

}
