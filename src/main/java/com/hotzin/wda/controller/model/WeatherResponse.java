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

    //private ClientRawModel clientRawModel;
    private static GeoCodeModel geoCodeModel;
    private Object geoCodeModelResultsObject;
    private Object clientRawModelObject;


    public static WeatherResponse constructResponse(GeoCodeModels geoCodeModels, ClientRawModel clientRawModel) {

        return WeatherResponse.builder()
                .geoCodeModelResultsObject(geoCodeModels.getLicenses()[0].getName())
                .clientRawModelObject(clientRawModel)
                .build();
    }

}