package com.mac.macstore.api.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mac.macstore.bll.abstractions.services.IDeviceService;
import com.mac.macstore.bll.models.DeviceEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private IDeviceService deviceService;

    public DeviceController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity getDevices()
    {
        try {
            var resStr = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(deviceService.getAll());
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PostMapping
    public ResponseEntity postBook(@RequestBody DeviceEntity entity)
    {
        try {
            deviceService.create(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PutMapping
    public ResponseEntity putBook(@RequestBody DeviceEntity entity)
    {
        try {
            deviceService.update(entity);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestParam int id)
    {
        try {
            deviceService.delete(id);
            return ResponseEntity.ok().body("OK!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }
}
