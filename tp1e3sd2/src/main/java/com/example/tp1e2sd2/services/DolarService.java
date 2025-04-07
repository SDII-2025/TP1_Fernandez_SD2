package com.example.tp1e2sd2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DolarService {

    private final String API_URL = "https://dolarapi.com/v1/dolares";

    @Autowired
    private RestTemplate restTemplate;

    public Object obtenerValores(String ask) {
        String url = API_URL + (ask.equals("ALL") ? "" : "/" + ask.toLowerCase());
        return restTemplate.getForEntity(url, Object.class).getBody();
    }
}

