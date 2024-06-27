package com.csmanager.model.shop.coachPerks;

import com.csmanager.model.match.MatchRules;
import com.csmanager.model.team.Team;

public class StatsVisibility extends AbstractPerk {
    private int level;

    public StatsVisibility(MatchRules matchRules) {
        super(matchRules);
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public void turnOn() {
        Team.increaseStatsVisibility();
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void activate() {

    }

    @Override
    public String description() {
        return "StatsVisibility allows you to see the stats of players.";
    }
}
