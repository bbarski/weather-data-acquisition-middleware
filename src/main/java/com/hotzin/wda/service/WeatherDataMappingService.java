package com.hotzin.wda.service;

import com.hotzin.wda.model.ClientRawModel;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataMappingService {

    public ClientRawModel mappData(String weatherData){
        return ClientRawModel.from(weatherData);
    }
}
