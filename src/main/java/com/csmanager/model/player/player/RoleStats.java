package com.csmanager.model.player.player;

import com.csmanager.model.player.roles.roleType.RoleType;

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

    String getView() {
        return String.format("""
                Stats roleType = %s  
                 rolePoints = %.2f
                  """, roleType, rolePoints);
    }
}
