package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private String name;
    private boolean status;

    public Item(@JsonProperty("name") String name,@JsonProperty("status") boolean status) {
        this.name = name;
        this.status = status;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isStatus() {
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
