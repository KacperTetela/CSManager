package com.csmanager.model.player.builder;

import com.csmanager.model.player.roles.roleType.RoleType;

import java.util.ArrayList;
import java.util.List;

public class StatsManager {
    private final List<RoleStats> allRoleStats = new ArrayList<>();

    public void add(RoleStats roleStats) {
        allRoleStats.add(roleStats);
    }

    public List<RoleStats> getAllRoleStats() {
        return allRoleStats;
    }

    public void increaseSkillByPotential(RoleType roleType) {
        RoleStats stats = getStatsByType(roleType);
        stats.increaseByPotential();
    }

    double getRolePoints(RoleType roleType) {
        RoleStats stats = getStatsByType(roleType);
        return stats.getRolePoints();
    }

    double getPotentialPoints(RoleType roleType) {
        RoleStats stats = getStatsByType(roleType);
        return stats.getPotentialPoints();
    }

    private RoleStats getStatsByType(RoleType roleType) {
        for (RoleStats allRoleStat : allRoleStats) {
            if (allRoleStat.getRoleType().equals(roleType)) {
                return allRoleStat;
            }
        }
        throw new RuntimeException("Stats not found");
    }

}
