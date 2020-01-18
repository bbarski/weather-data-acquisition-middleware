package com.hotzin.wda.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CitiesToWSUrlsMappingService {

    //TODO Handle null WSUrl
    public String mapCityNameToWSUrl(String cityName) {

        Map map;
        String WSUrl = null;

        try {
            map = mapFromFile();
            WSUrl = (String) map.get(cityName.toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
          }

        return WSUrl;

    }

    //TODO init map at app start
    private Map<String, String> mapFromFile() throws IOException {
   //TODO validate/sanitize file before read
        String filePath = "src/main/resources/weatherstationsUrls.txt";
        Path path = FileSystems.getDefault().getPath(filePath);

        return Files.lines(path).collect(Collectors.toMap(k -> k.split("=")[0], v -> v.split("=")[1]));
    }

}
