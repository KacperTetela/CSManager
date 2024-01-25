package com.csmanager;

import com.csmanager.carrer.startingLineUp.Role;
import com.csmanager.carrer.startingLineUp.Side;

import java.util.*;

public class Player {
    private String name;
    private int age;
    private int daysInTeams;
    private double consistency;
    private Map<Role, Double> potentialPoints = new HashMap<>();
    private Map<Role, Double> rolePoints = new HashMap<>();

    public Player(String name) {
        this.name = name;
        double potentialVSRolesPoints = 0.5;
        double potentialVal = 0.5 + Math.random() * potentialVSRolesPoints;
        Role.getPotentialRoles().forEach(role -> potentialPoints.put(role, potentialVal));

        potentialVSRolesPoints = -potentialVal;
        double roleVal = 0.5 + Math.random() * potentialVSRolesPoints;
        Arrays.stream(Role.values()).forEach(role -> rolePoints.put(role, potentialVal));

        consistency = 0.5 + Math.random() * 0.5;
        daysInTeams = (int) (Math.random() * 1000);
        age = (int) (Math.random() * 20 + 15);
    }

    @Override
    public String toString() {
        return "Player{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", daysInTeams=" + daysInTeams +
                ", consistency=" + consistency +
                ", potential=" + potentialPoints +
                ", rolePoints=" + rolePoints +
                '}';
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

    public double getSkillLevel() {
        double skillLevel = 0;
        for (Role role : Role.values()) {
            if (potentialPoints.get(role) == null) {
                continue;
            }
            skillLevel += potentialPoints.get(role) * rolePoints.get(role);
        }
        return skillLevel;
    }

    public void addPoints(Role role) {
        if (!role.getSide().equals(Side.CT)) {
            double val = rolePoints.get(role) + potentialPoints.get(role) * 0.1;
            rolePoints.put(role, val);
        }
    }
}