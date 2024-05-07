package com.csmanager.model.shop.coachPerks;

import com.csmanager.model.match.MatchRules;

public class Profitable extends AbstractPerk {
    private static final int VALUE = 500;
    public Profitable(MatchRules matchRules) {
        super(matchRules);
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public void turnOn() {
        matchRules.changePrize(VALUE);
    }

    @Override
    public void turnOff() {
        matchRules.changePrize(-VALUE);
    }

    @Override
    public void activate() {

    }

    @Override
    public String description() {
        return "Gives you the opportunity to earn more per match";
    }
}
