package com.example.Adapter.DTO;

import com.example.Adapter.model.Coordinates;

public class MessageADTO {
    private String msg;
    private String lng;
    private Coordinates coordinates;

    public MessageADTO(String msg, String lng, Coordinates coordinates) {
        this.msg = msg;
        this.lng = lng;
        this.coordinates = coordinates;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}



