package com.project.shopsmart.controller;

import com.project.shopsmart.manager.LuUserManager;
import com.project.shopsmart.model.LuUser;
import com.project.shopsmart.repository.LuUserRepository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@CrossOrigin
public class LuUserController {

    @Autowired
    LuUserRepository luUserRepository;

    private LuUserManager luUserManager;

    @Autowired
    public LuUserController(LuUserManager luUserManager) {
        this.luUserManager = luUserManager;
    }

    @GetMapping("/users")
    public List<LuUser> getAllNotes() {
        return luUserRepository.findAll();
    }

    @PostMapping("/users")
    public LuUser createNote(@RequestBody LuUser luUser) {
        luUser.setCreateTime(new Date());
        luUser.setUpdateTime(new Date());
        return luUserRepository.save(luUser);
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestParam Integer userId, @RequestParam String newPassword) {
        return ResponseEntity.ok(luUserManager.updatePassword(userId, newPassword, new Date()));
    }

    @PostMapping("/loginAuth")
    public ResponseEntity<String> postMethodName(@RequestBody String authBody) {
        JSONObject authJSON = new JSONObject(authBody);
        Boolean successfulLogin = luUserManager.isAuthSuccessful(authJSON.getString("emailId"),
                authJSON.getString("password"));
        return ResponseEntity.ok(String.valueOf(successfulLogin));
    }

}
