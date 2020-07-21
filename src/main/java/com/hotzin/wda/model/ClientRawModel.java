package com.hotzin.wda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ClientRawModel {

    private String avgSpeedKnots;//1
    private String windDirCompass;//3
    private String outsideTempCelsius;//4
    private String outsideHumidityPercent;//5
    private String barometerHPa;//6
    private String hourTime;//29
    private String minuteTime;//30
    private String secondsTime;//31
    //private String stationName;//32
    private String dayTime;//35
    private String monthTime;//36
    private String weatherDesc;//49
    //private String dateLabel;//74
    private String latitude;//160 (- for southern hemisphere) Reverse Geocoding
    private String longitude;//161 (- for EAST of GMT)

    public static ClientRawModel from(String stringData) {
        String[] tokenizedData = stringData.split(" ");


        return ClientRawModel.builder()
                .latitude(tokenizedData[160])
                .longitude(tokenizedData[161])
                .avgSpeedKnots(tokenizedData[1])
                .windDirCompass(tokenizedData[3])
                .outsideTempCelsius(tokenizedData[4])
                .outsideHumidityPercent(tokenizedData[5])
                .barometerHPa(tokenizedData[6])
                .hourTime(tokenizedData[29])
                .minuteTime(tokenizedData[30])
                .secondsTime(tokenizedData[31])
                //.stationName(tokenizedData[32])
                .dayTime(tokenizedData[35])
                .monthTime(tokenizedData[36])
                .weatherDesc(tokenizedData[49])
                //.dateLabel(tokenizedData[74])
                .build();
    }

}
