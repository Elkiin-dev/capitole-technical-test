package com.capitole.productCatalog.shared.infraestructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(value = "/health")
    public String handler (){
        return "ok";
    }
}
