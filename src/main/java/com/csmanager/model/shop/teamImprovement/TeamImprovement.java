package com.csmanager.model.shop.teamImprovement;

import com.csmanager.model.player.roles.roleType.RoleType;
import com.csmanager.model.team.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamImprovement {
    private String improvementName;
    private int price;
    private Map<RoleType, Double> roleTypeDoubleMap = new HashMap<>();
    private Team team;

    public TeamImprovement(Team team) {
        this.team = team;
    }

    private void changeStats() {

    }

}