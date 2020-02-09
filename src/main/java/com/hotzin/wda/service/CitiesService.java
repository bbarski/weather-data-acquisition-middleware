package com.hotzin.wda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class CitiesService {

    @Autowired
    @Qualifier(value = "cityMapper")
    private Map<String, String> cityMapper;


    public List<String> returnAllCities(){

        return new ArrayList<>(cityMapper.keySet());
    }


}
