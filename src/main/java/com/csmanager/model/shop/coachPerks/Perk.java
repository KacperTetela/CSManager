package com.csmanager.model.shop.coachPerks;

public interface Perk {
    int getPrice();
    void turnOn();
    void turnOff();
    void activate();
    String description();
}
