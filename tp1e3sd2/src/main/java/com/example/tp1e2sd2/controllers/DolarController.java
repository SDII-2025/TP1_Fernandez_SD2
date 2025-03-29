package com.example.tp1e2sd2.controllers;

import com.example.tp1e2sd2.services.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dollar")
class DolarController {
    @Autowired
    private DolarService dolarService;

    @GetMapping("/values")
    public Map obtenerValor(@RequestParam(defaultValue = "ALL") String ask) {
        return dolarService.obtenerValores(ask);
    }
}

