package com.hotzin.wda.controller.model;

import com.hotzin.wda.client.model.GeoCodeModel;
import com.hotzin.wda.model.ClientRawModel;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
//TODO map clientRawModel to WeatherResponse

    //private ClientRawModel clientRawModel;
    //private GeoCodeModel geoCodeModel;
    private String geoCodeModelLabelField;
    private String clientRawModelOutsideTempCelsius;


    public static WeatherResponse constructResponse(GeoCodeModel geoCodeModel, ClientRawModel clientRawModel) {

        return WeatherResponse.builder()
                .geoCodeModelLabelField(geoCodeModel.data[0].toString())
                .clientRawModelOutsideTempCelsius(clientRawModel.getOutsideTempCelsius())
                .build();
    }

}
