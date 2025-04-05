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
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    private @ResponseBody List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/get")
    private @ResponseBody UserModel getUser(@RequestParam final Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(path = "/update")
    private @ResponseBody UserModel updateUser(@RequestBody final Long userId, @RequestBody UserModel user) {
        return userService.updateUser(userId, user);
    }

    @PostMapping(path = "/delete")
    private ResponseEntity<?> deleteUser(@RequestParam final Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public @ResponseBody String authentication(){
        return "888";
    }

}
