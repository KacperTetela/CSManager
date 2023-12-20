package com.csmanager.carrer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShopCreator {
    private Map<Integer,Shop> shopMap = new HashMap<>();
    private String[] names = {"Buy bootcamp","Buy seat","Buy another player","Buy squad(5 players)","Buy coach skills","Sell player"};

    public ShopCreator() {
        Arrays.stream(names).allMatch(name -> {
            Shop shop = new Shop(name, 100);
            shopMap.put(shopMap.size(),shop);
            return true;
        });
    }

    @Override
    public String toString() {
        return "shopMap=\n" + shopMap;
    }
}
