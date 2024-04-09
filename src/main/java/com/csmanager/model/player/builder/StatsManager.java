package com.csmanager.model.player.builder;

import com.csmanager.model.player.roles.roleType.RoleType;

import java.util.ArrayList;
import java.util.List;

public class StatsManager {
    private List<RoleStats> allroleStats = new ArrayList<>();

    public void add(RoleStats roleStats) {
        allroleStats.add(roleStats);
    }

    public List<RoleStats> getAllroleStats() {
        return allroleStats;
    }

    public void increaseSkillByPotential(RoleType roleType) {
        RoleStats stats = getStatsByType(roleType);
        stats.increaseByPotential();
    }

    double getRolePoints(RoleType roleType) {
        RoleStats stats = getStatsByType(roleType);
        return stats.getRolePoints();
    }

    double getPotenitalPoints(RoleType roleType) {
        RoleStats stats = getStatsByType(roleType);
        return stats.getPotentialPoints();
    }

    private RoleStats getStatsByType(RoleType roleType) {
        for (RoleStats allroleStat : allroleStats) {
            if (allroleStat.getRoleType().equals(roleType)) {
                return allroleStat;
            }
        }
        throw new RuntimeException("Stats not found");
    }

}
