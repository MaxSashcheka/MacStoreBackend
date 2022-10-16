package com.mac.macstore.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mac.macstore.bll.abstractions.services.IUserService;
import com.mac.macstore.bll.models.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/users")
public class UsersController {
    private IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            var resStr = new ObjectMapper()
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(userService.getAll());
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserEntity entity) {
        try {
            userService.create(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity putUser(@RequestBody UserEntity entity) {
        try {
            userService.update(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam int id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }
}