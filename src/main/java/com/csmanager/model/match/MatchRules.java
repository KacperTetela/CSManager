package com.csmanager.model.match;

public class MatchRules {
    private int prize = 200;
    private int lossBounty = 100;

    public int getPrize() {
        return prize;
    }

    public void changePrize(int prize) {
        this.prize += prize;
    }

    public int getLossBounty() {
        return lossBounty;
    }

    public void changeLossBounty(int lossBounty) {
        this.lossBounty = lossBounty;
    }
}
