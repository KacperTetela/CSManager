package com.csmanager.model.match;

public class MatchRules {
    private int prize = 200;

    public int getPrize() {
        return prize;
    }

    public void changePrize(int prize) {
        this.prize += prize;
    }
}
