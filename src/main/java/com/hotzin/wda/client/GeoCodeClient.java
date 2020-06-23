package com.hotzin.wda.client;

import com.hotzin.wda.client.model.GeoCodeModels;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class GeoCodeClient {

    //?q=LAT+LNG&key=

    private final RestTemplate restTemplate;
    private final String MAIN_URL = "https://api.opencagedata.com/geocode/v1/json";
    private final String access_key = "1a7b9de81aa5420fb668509d651f2450";

    public GeoCodeModels mapToLocation(String latitude, String longitude){
        String uriString = UriComponentsBuilder.fromHttpUrl(MAIN_URL)
                .queryParam("key", access_key)
                .queryParam("q", latitude + "," + "-" + longitude.replace("-",""))
                .build()
                .toUriString();

        ResponseEntity<GeoCodeModels> response = restTemplate
                .getForEntity(uriString, GeoCodeModels.class);

        return response.getBody();

    }


}
