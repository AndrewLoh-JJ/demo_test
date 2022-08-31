package com.example.demo.model;

import java.util.UUID;

public class Item {
    private final UUID id;
    private String name;
    private boolean status;

    public Item(UUID id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return false;
    }
}
