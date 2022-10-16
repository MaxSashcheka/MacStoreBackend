package com.mac.macstore.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.models.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private IProductService productService;

    public ProductsController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getProducts()
    {
        try {
            var resStr = new ObjectMapper()
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(
                            productService.getAll()
                    );
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody ProductEntity entity)
    {
        try {
            productService.create(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PutMapping
    public ResponseEntity putProduct(@RequestBody ProductEntity entity)
    {
        try {
            productService.update(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam int id)
    {
        try {
            productService.delete(id);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }
}
