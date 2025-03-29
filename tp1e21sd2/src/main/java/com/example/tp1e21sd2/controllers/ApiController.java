package com.example.tp1e21sd2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/my-ip")
    public ResponseEntity<String> obtenerIp() {
        String url = "https://api.ipify.org?format=json";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/postal/{pais}/{codigoPostal}")
    public ResponseEntity<String> getPostalInfo(@PathVariable String pais, @PathVariable String codigoPostal) {
        String url = "http://api.zippopotam.us/" + pais + "/" + codigoPostal;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info-sol")
    public ResponseEntity<String> obtenerInfoSolar(@RequestParam double lat, @RequestParam double lng) {
        String url = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + lng;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}
