package com.hotzin.wda.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCodeModels {
    public String documentation;
    public Licenses[] licenses;
    public Object rate;
    public Results[] results;
    public Object status;
    public Object stay_informed;
    public String thanks;
    public Object timestamp;
    public String total_results;

    @Setter
    @Getter
    public static class Licenses{
        public String name;
        public String url;
    }

    @Setter
    @Getter
    public static class Results{
        Components components;

        @Setter
        @Getter
        public static class Components{
            public String town;
            public String city;
            public String village;
        }

    }


}
