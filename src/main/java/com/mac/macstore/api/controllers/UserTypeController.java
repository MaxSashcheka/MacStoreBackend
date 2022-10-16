package com.mac.macstore.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mac.macstore.bll.abstractions.services.IProductTypeService;
import com.mac.macstore.bll.abstractions.services.IUserTypeService;
import com.mac.macstore.bll.models.ProductTypeEntity;
import com.mac.macstore.bll.models.UserTypeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/users/types")
public class UserTypeController {
    private IUserTypeService userTypeService;

    public UserTypeController(IUserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    public ResponseEntity getUserTypes() {
        try {
            var resStr = new ObjectMapper()
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(
                            userTypeService.getAll()
                    );
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity postUserType(@RequestBody UserTypeEntity entity)
    {
        try {
            userTypeService.create(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity putUserType(@RequestBody UserTypeEntity entity) {
        try {
            userTypeService.update(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUserType(@RequestParam int id) {
        try {
            userTypeService.delete(id);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }
}
