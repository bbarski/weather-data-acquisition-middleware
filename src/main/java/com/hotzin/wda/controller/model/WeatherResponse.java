package com.hotzin.wda.controller.model;

import com.hotzin.wda.client.model.GeoCodeModel;
import com.hotzin.wda.client.model.GeoCodeModels;
import com.hotzin.wda.model.ClientRawModel;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
//TODO map clientRawModel to WeatherResponse

    private String clientRawModelOutsideTempCelsius;
    private String clientRawModelBarometerHPa;
    private String clientRawModelWeatherDesc;
    private String clientRawModelOutsideHumidityPercent;
    private String clientRawModelAvgSpeedKnots;

    public static WeatherResponse constructResponse(GeoCodeModels geoCodeModels, ClientRawModel clientRawModel) {

        return WeatherResponse.builder()
                .clientRawModelOutsideTempCelsius(clientRawModel.getOutsideTempCelsius())
                .clientRawModelBarometerHPa(clientRawModel.getBarometerHPa())
                .clientRawModelWeatherDesc(clientRawModel.getWeatherDesc())
                .clientRawModelOutsideHumidityPercent(clientRawModel.getOutsideHumidityPercent())
                .clientRawModelAvgSpeedKnots(clientRawModel.getAvgSpeedKnots())
                .build();
    }

}