package com.hotzin.wda.service;

import com.hotzin.wda.model.ClientRawModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherDataMappingService {

    public ClientRawModel mapData(String weatherData){

        return ClientRawModel.from(weatherData);

    }
}
