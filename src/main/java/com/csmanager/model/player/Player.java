package com.csmanager.model.player;

import com.csmanager.model.lineUp.Role;
import com.csmanager.model.lineUp.Side;
import com.csmanager.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Player {
    private String name;
    private int age;
    private int daysInTeams;
    private double consistency;
    private Map<Role, Double> potentialPoints = new HashMap<>();
    private Map<Role, Double> rolePoints = new HashMap<>();
    private boolean busy;

    public Player(String name, PlayerStatsScope playerStatsScope) {
        this.name = name;
        Role.getPotentialRoles().forEach(role -> {
            potentialPoints.put(role, playerStatsScope.rollPotential());
            rolePoints.put(role, playerStatsScope.rollValue());
        });
        consistency = 0.5 + Math.random() * 0.5;
        daysInTeams = (int) (Math.random() * 1000);
        age = (int) (Math.random() * 20 + 15);
    }

    /**
     * The method returns the real skill index of a given player, which is the sum of all his statistics.
     * Each role with potential is checked in the context of a "chance" or a good day for the player
     */
/*    public double getSkillLevel() {
        double skillLevel = 0;
        for (Role role : Role.values()) {
            if (potentialPoints.get(role) == null) {
                continue;
            } else {
                //chance(role);
            }
            skillLevel += rolePoints.get(role);
        }
        return skillLevel;
    }*/



/*    private double chance(Role role) {
        double isItTime = Math.random();
        if (isItTime <= potentialPoints.get(role)) {
            System.out.println("Dobrze idzie!  " + name);
            if (rolePoints.get(role) < 0.75)
                return rolePoints.get(role) + 0.25;
            else
                return 1.0;
        }
        return rolePoints.get(role);
    }*/
    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Map<Role, Double> getPotentialPoints() {
        return potentialPoints;
    }

    public Map<Role, Double> getRolePoints() {
        return rolePoints;
    }

    @Override
    public String toString() {
        return "\n" + name +
                "\nrolePoints=" + Utils.createMapDisplay(rolePoints) +
                "\npotentialPoints=" + Utils.createMapDisplay(potentialPoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void addPoints(Role role) {
        if (!role.getSide().equals(Side.CT)) {
            double val = rolePoints.get(role) + potentialPoints.get(role) * 0.1;
            rolePoints.put(role, val);
        }
    }
}