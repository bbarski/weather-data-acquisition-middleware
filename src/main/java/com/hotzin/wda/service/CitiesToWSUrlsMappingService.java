package com.hotzin.wda.service;

import com.hotzin.wda.configuration.exception.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class CitiesToWSUrlsMappingService {

    @Autowired
    @Qualifier(value = "cityMapper")
    private Map<String, String> cityMapper;

    public String mapCityNameToWSUrl(String cityName) {
        String city = cityMapper.get(cityName.toLowerCase());

        return Optional.ofNullable(city)
                .orElseThrow(() -> {
                    log.error("city : {} could not be mapped", cityName);
                    throw new CityNotFoundException(String.format("city %s could not be mapped ", cityName));
                });
    }


}
