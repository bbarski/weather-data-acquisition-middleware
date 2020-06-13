package com.hotzin.wda.client;

import com.hotzin.wda.client.model.GeoCodeModel;
import com.hotzin.wda.client.model.GeoCodeModelWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.HttpMethod.GET;

@RequiredArgsConstructor
@Service
public class GeoCodeClient {

    private final RestTemplate restTemplate;
    private final String MAIN_URL = "http://api.positionstack.com/v1/reverse";
    private final String access_key = "1dd7c939e96347686e3931a398ad1cb7";

    public GeoCodeModel mapToLocation(String latitude, String longitude){
        String uriString = UriComponentsBuilder.fromHttpUrl(MAIN_URL)
                .queryParam("access_key", access_key)
                .queryParam("query", latitude+","+"-"+longitude)
                .build()
                .toUriString();

        ResponseEntity<GeoCodeModel> response = restTemplate
                .getForEntity(uriString,GeoCodeModel.class);

        return response.getBody();

    }


}
