package com.mac.macstore.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mac.macstore.bll.abstractions.services.IBasketService;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.models.BasketEntity;
import com.mac.macstore.bll.models.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    private IBasketService basketService;

    public BasketController(IBasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public ResponseEntity getBasket(@RequestParam int id) {
        try {
            var resStr = new ObjectMapper()
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(
                            basketService.getAll(id)
                    );
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity postBasket(@RequestBody BasketEntity entity) {
        try {
            basketService.create(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity putBasket(@RequestBody BasketEntity entity) {
        try {
            basketService.update(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteBasket(@RequestParam int id) {
        try {
            basketService.delete(id);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }
}
