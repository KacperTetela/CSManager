package com.csmanager.model.shop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShopCreator {
    private String[] names = {"Buy bootcamp","Buy seat","Buy another player","Buy squad(5 players)","Buy coach skills","Sell player"};

    public ShopCreator() {
        Arrays.stream(names).allMatch(name -> {
            return true;
        });
    }

    @Override
    public String toString() {
        return "shopMap=\n";
    }
}