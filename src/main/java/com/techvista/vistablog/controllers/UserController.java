package com.techvista.vistablog.controllers;

import com.techvista.vistablog.models.UserModel;
import com.techvista.vistablog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    private @ResponseBody UserModel saveUser(@RequestBody UserModel user) {
        return userService.save(user);
    }

    @GetMapping("/getAll")
    private @ResponseBody List<UserModel> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/get")
    private @ResponseBody UserModel getUser(@RequestParam final Long userId) {
        return userService.get(userId);
    }

    @PostMapping(path = "/update")
    private @ResponseBody UserModel updateUser(@RequestBody final Long userId, UserModel user) {
        return userService.update(userId, user);
    }

    @PostMapping(path = "/delete")
    private ResponseEntity<?> deleteUser(@RequestParam final Long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public @ResponseBody String authentication(){
        return "888";
    }

}
