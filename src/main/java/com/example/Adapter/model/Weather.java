package com.example.Adapter.model;

import com.example.Adapter.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Weather {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private String createdDt;
    private Integer currentTemp;

    public Weather(String createdDt, Integer currentTemp) {
        this.createdDt = createdDt;
        this.currentTemp = currentTemp;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    public Integer getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Integer currentTemp) {
        this.currentTemp = currentTemp;
    }
}
