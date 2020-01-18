package com.hotzin.wda.controller;

import com.hotzin.wda.model.ClientRawModel;
import com.hotzin.wda.service.CitiesToWSUrlsMappingService;
import com.hotzin.wda.service.WeatherDataAquirerService;
import com.hotzin.wda.service.WeatherDataMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;


@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherDataAquirerService weatherDataAquirerService;
    private final WeatherDataMappingService weatherDataMappingService;
    private final CitiesToWSUrlsMappingService citiesToWSUrlsMappingService;

    @GetMapping("/")
    @ResponseBody
    public HttpEntity<ClientRawModel> weatherEndpoint(@RequestParam String cityName){

        String weatherStationURI = citiesToWSUrlsMappingService.mapCityNameToWSUrl(cityName);
        String weatherData = weatherDataAquirerService.getWeatherData(URI.create(weatherStationURI));
        ClientRawModel clientRawModel = weatherDataMappingService.mappData(weatherData);
        return new HttpEntity<>(clientRawModel);
    }

}
