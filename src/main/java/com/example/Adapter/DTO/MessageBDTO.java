package com.example.Adapter.DTO;

public class MessageBDTO {
    private String txt;
    private Integer currentTemp;
    private String createdDt;

    public MessageBDTO(String txt, Integer currentTemp, String createdDt) {
        this.txt = txt;
        this.currentTemp = currentTemp;
        this.createdDt = createdDt;
    }

    public MessageBDTO() {
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Integer getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Integer currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }
}
