package com.hotzin.wda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class CityMappingConfiguration {

    public static InputStream accessFile() {
        String resource = "weatherstationsUrls.txt";

        // this is the path within the jar file
        InputStream input = CityMappingConfiguration.class.getResourceAsStream("/resources/" + resource);
        if (input == null) {
            // this is how we load file within editor (eg eclipse)
            input = CityMappingConfiguration.class.getClassLoader().getResourceAsStream(resource);
        }

        return input;
    }

    @Bean(name = "cityMapper")
    public Map<String, String> cityMapper() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(accessFile()));

        String line;
        Map<String, String> map = new HashMap<>();
        while ((line = br.readLine()) != null) {
            map.put(line.split("=")[0], line.split("=")[1]);
        }


        return map;
    }
}
