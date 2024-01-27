package com.project.shopsmart.controller;

import com.project.shopsmart.exception.ResourceNotFoundException;
import com.project.shopsmart.model.LuUser;
import com.project.shopsmart.repository.LuUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@CrossOrigin
public class LuUserController {

    @Autowired
    LuUserRepository luUserRepository;



    @GetMapping("/users")
    public List<LuUser> getAllNotes() {
        return luUserRepository.findAll();
    }

    @PostMapping("/users")
    public LuUser createNote(@RequestBody LuUser note) {
        return luUserRepository.save(note);
    }
}
