package com.hotzin.wda.controller.model;

import com.hotzin.wda.client.model.GeoCodeModels;
import com.hotzin.wda.model.ClientRawModel;
import lombok.*;

import java.util.Optional;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    private String clientRawModelOutsideTempCelsius;
    private String clientRawModelBarometerHPa;
    private String clientRawModelWeatherDesc;
    private String clientRawModelOutsideHumidityPercent;
    private String clientRawModelAvgSpeedKnots;
    private String clientRawModelLatitude;
    private String clientRawModelLongitude;
    private String geoCodeModelsPlace;
    private String geoCodeModelsISO_3166_1_alpha_3;

    public static WeatherResponse constructResponse(GeoCodeModels geoCodeModels, ClientRawModel clientRawModel) {

        String place =
                Optional.ofNullable(geoCodeModels.results[0].getComponents().getTown())
                        .orElse(Optional.ofNullable(geoCodeModels.results[0].getComponents().getCity())
                        .orElse(Optional.ofNullable(geoCodeModels.results[0].getComponents().getVillage())
                        .orElse(Optional.ofNullable(geoCodeModels.results[0].getComponents().getState())
                        .orElse("Unknown"))));

        return WeatherResponse.builder()
                .clientRawModelOutsideTempCelsius(clientRawModel.getOutsideTempCelsius())
                .clientRawModelBarometerHPa(clientRawModel.getBarometerHPa())
                .clientRawModelWeatherDesc(clientRawModel.getWeatherDesc())
                .clientRawModelOutsideHumidityPercent(clientRawModel.getOutsideHumidityPercent())
                .clientRawModelAvgSpeedKnots(clientRawModel.getAvgSpeedKnots())
                .clientRawModelLatitude(clientRawModel.getLatitude())
                .clientRawModelLongitude(clientRawModel.getLongitude())
                .geoCodeModelsPlace(place)
                .geoCodeModelsISO_3166_1_alpha_3(geoCodeModels.results[0].getComponents().getISO_3166_1_alpha_3())
                .build();
    }

}