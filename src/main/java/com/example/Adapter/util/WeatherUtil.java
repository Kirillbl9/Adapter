package com.example.Adapter.util;

import com.example.Adapter.model.Weather;
import com.example.Adapter.service.MessageService;
import org.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.Scanner;

public class WeatherUtil {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    public static Weather getWeatherData(String latitude, String longitude) throws JSONException {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=6fff53a641b9b9a799cfd6b079f5cd4e");

            Scanner in = new Scanner((InputStream) url.getContent());
            String result = "";
            while (in.hasNext()) {
                result += in.nextLine();
            }

            JSONObject jsonObject = new JSONObject(result);
            JSONObject main = jsonObject.getJSONObject("main");

            Integer currentTemp = main.getInt("temp");
            //API почему-то возвращает юникс время на 3ч меньше реального
            Long timeStamp = jsonObject.getLong("dt");
            String createdDt = getDateByUnixTimeStamp(timeStamp);
            return new Weather(createdDt, currentTemp);
        } catch (IOException e) {
            logger.error("Weather service error");
        }
        return null;
    }

    //In rfc3339 format
    private static String getDateByUnixTimeStamp(Long timeStamp) {
        String date = Instant.ofEpochMilli(timeStamp * 1000).toString();
        return date;
    }
}

