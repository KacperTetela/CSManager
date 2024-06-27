package com.csmanager.model.player.player;

import com.csmanager.model.player.roles.roleType.RoleType;

import java.util.Random;

public class RoleStats {
    private RoleType roleType;
    private double potentialPoints;
    private double rolePoints;

    public RoleStats(RoleType roleType, double potentialPoints, double rolePoints) {
        this.roleType = roleType;
        this.potentialPoints = potentialPoints;
        this.rolePoints = rolePoints;
    }

    public RoleStats() {
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public double getPotentialPoints() {
        return potentialPoints;
    }

    public double getRolePoints() {
        return rolePoints;
    }

    public void increaseByPotential() {
        rolePoints = rolePoints + (potentialPoints * 0.1);
    }

    @Override
    public String toString() {
        return String.format("""
                RoleStats{ 
                roleType=  %s
                , potentialPoints=  %.2f
                , rolePoints=  %.2f
                }""", roleType, potentialPoints, rolePoints);
    }

    String getView(int areStatsEnable) {
        /**
         *              accuracy of observations (% perhaps of failing)
         * level 1 ->   30%
         * level 2 ->   20%
         * level 3 ->   15%
         * level 4 ->   10%
         * level 5 ->   5%
         */
        Random random = new Random();
        boolean pointer = random.nextBoolean();
        double rolePointsModificator;
        switch (areStatsEnable) {
            case 1 -> rolePointsModificator = (Math.random() * 0.2 + 0.1);
            case 2 -> rolePointsModificator = (Math.random() * 0.1 + 0.1);
            case 3 -> rolePointsModificator = (Math.random() * 0.1 + 0.05);
            case 4 -> rolePointsModificator = (Math.random() * 0.1);
            default -> rolePointsModificator = (Math.random() * 0.05);
        }
        if (pointer) {
            rolePointsModificator = 0 + rolePointsModificator;
        } else {
            rolePointsModificator = 0 - rolePointsModificator;
        }
        if (areStatsEnable > 0) {
            String view = String.format("""
                    Stats roleType = %s  
                     rolePoints = %.2f
                      """, roleType, rolePoints + rolePointsModificator);
            return view;
        }
        return "?";
    }
}
