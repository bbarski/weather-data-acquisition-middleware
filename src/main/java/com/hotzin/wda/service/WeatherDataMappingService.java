package com.hotzin.wda.service;

import com.hotzin.wda.client.GeoCodeClient;
import com.hotzin.wda.client.model.GeoCodeModel;
import com.hotzin.wda.model.ClientRawModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherDataMappingService {

    public ClientRawModel mapData(String weatherData){

        ClientRawModel clientRawModel = ClientRawModel.from(weatherData);

        return clientRawModel;
    }
}
