package com.csmanager.model.shop.coachPerks;

import com.csmanager.model.match.MatchRules;

public class PotentialVisibility extends AbstractPerk {
    private int level;

    public PotentialVisibility(MatchRules matchRules) {
        super(matchRules);
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void activate() {
        //bedzie sout potential
    }

    @Override
    public String description() {
        return "PotentialVisibility allows you to see the potential of players.";
    }
}
