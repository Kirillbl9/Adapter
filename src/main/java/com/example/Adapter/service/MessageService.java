package com.example.Adapter.service;

import com.example.Adapter.DTO.MessageADTO;
import com.example.Adapter.DTO.MessageBDTO;
import com.example.Adapter.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.Adapter.util.WeatherUtil.getWeatherData;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private List<MessageBDTO> list = new ArrayList<>();

    public void addMessage(MessageADTO messageA) {

        if (messageA.getMsg().isEmpty()) {
            logger.info("message empty");
        }

        if (messageA.getLng().equals("ru")) {
            Weather weatherData = getWeatherData(messageA.getCoordinates().getLatitude(), messageA.getCoordinates().getLongitude());
            MessageBDTO messageB = new MessageBDTO();
            messageB.setCurrentTemp(weatherData.getCurrentTemp());
            messageB.setCreatedDt(weatherData.getCreatedDt());
            messageB.setTxt("Привет");
            list.add(messageB);
        } else {
            logger.info("not ru message" + messageA.getMsg());
        }
    }

    public MessageBDTO getMessages() {
        if(list.isEmpty()){
            return new MessageBDTO();
        }
        return list.get(list.size()-1);
    }
}

