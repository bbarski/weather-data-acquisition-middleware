package com.hotzin.wda.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherDataAquirerService {

    private final RestTemplate restTemplate;

    public String getWeatherData(URI uri){
        return restTemplate.getForObject(uri, String.class);
    }
}
