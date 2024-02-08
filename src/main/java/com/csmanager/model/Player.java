package com.csmanager.model;

import com.csmanager.model.startingLineUp.Role;
import com.csmanager.model.startingLineUp.Side;
import com.csmanager.utils.Utils;

import java.util.*;

public class Player {
    private String name;
    private int age;
    private int daysInTeams;
    private double consistency;
    private Map<Role, Double> potentialPoints = new HashMap<>();
    private Map<Role, Double> rolePoints = new HashMap<>();

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

    @Override
    public String toString() {
        return  "\n"+name  +
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

    /**
     * The method returns the real skill index of a given player, which is the sum of all his statistics.
     * Each role with potential is checked in the context of a "chance" or a good day for the player
     */
    public double getSkillLevel() {
        double skillLevel = 0;
        for (Role role : Role.values()) {
            if (potentialPoints.get(role) == null) {
                continue;
            } else {
                chance(potentialPoints.get(role), role);
            }
            skillLevel += rolePoints.get(role);
        }
        return skillLevel;
    }

    public void addPoints(Role role) {
        if (!role.getSide().equals(Side.CT)) {
            double val = rolePoints.get(role) + potentialPoints.get(role) * 0.1;
            rolePoints.put(role, val);
        }
    }

    /**
     * The method is intended to provide the opportunity to significantly improve skill points for one match if the
     * player finds himself in the pool.
     * The method takes into account that the lower the potential coefficient, the lower the chance for a given player
     * to have an opportunity.
     *
     *         // 3 nooby, 2 koxy i 1 pro
     *
     *         // 0.2 - 0.25 // pro
     *         // 0.1 - 0.2 // kox
     *         // 0.05 - 0.1 // noob
     */
    private void chance(double potential, Role role) {
        double isItTime = Math.random();
        if (isItTime <= potentialPoints.get(role)) {
            if (rolePoints.get(role) < 0.75)
                rolePoints.put(role, (rolePoints.get(role) + 0.25) );
            else
                rolePoints.put(role, 1.0);
        }
    }

}