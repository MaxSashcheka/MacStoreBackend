package com.mac.macstore.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mac.macstore.bll.abstractions.services.IProductTypeService;
import com.mac.macstore.bll.models.ProductTypeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/products/types")
public class ProductTypeController {
    private IProductTypeService productTypeService;

    public ProductTypeController(IProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public ResponseEntity getProductTypes() {
        try {
            var resStr = new ObjectMapper()
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(
                            productTypeService.getAll()
                    );
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity postProductType(@RequestBody ProductTypeEntity entity) {
        try {
            productTypeService.create(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity putProductType(@RequestBody ProductTypeEntity entity) {
        try {
            productTypeService.update(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteProductType(@RequestParam int id) {
        try {
            productTypeService.delete(id);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e) {
            return internalServerError().body("Some problem with server - " + e.getMessage());
        }
    }
}
