package com.csmanager.model.player;

import com.csmanager.model.match.Match;
import com.csmanager.model.match.MatchStage;
import com.csmanager.model.roles.roleType.RoleType;
import com.csmanager.model.roles.roleType.Side;
import com.csmanager.model.roles.roles.*;
import com.csmanager.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Player {
    private String name;
    private int age;
    private int daysInTeams;
    private double consistency;
    private Roles roles;
    /**
     * stworzyc nowa klase PerformanceScope ktora bedzie raz na mecz tworzyla realny perforamnce gracza za pomoca jakiejs skali,
     * biorac pod uwage rolePointsy oraz bedzie warunkowalo powtarzalnosc na podstawie doswiadczenia liczonego w latach i dniach w druzynir
     */
    private Map<RoleType, Double> potentialPoints = new HashMap<>();
    private Map<RoleType, Double> rolePoints = new HashMap<>();
    private boolean busy;

    public Player(String name, PlayerStatsScope playerStatsScope) {
        this.name = name;
        RoleType.getPotentialRoles().forEach(role -> {
            potentialPoints.put(role, playerStatsScope.rollPotential());
            rolePoints.put(role, playerStatsScope.rollValue());
        });
        consistency = 0.5 + Math.random() * 0.5;
        daysInTeams = (int) (Math.random() * 1000);
        age = (int) (Math.random() * 20 + 15);
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Map<RoleType, Double> getPotentialPoints() {
        return potentialPoints;
    }

    public Map<RoleType, Double> getRolePoints() {
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

    public void addPoints(RoleType roleType) {
        if (!roleType.getSide().equals(Side.CT)) {
            double val = rolePoints.get(roleType) + potentialPoints.get(roleType) * 0.1;
            rolePoints.put(roleType, val);
        }
    }

    public void setRoles(RoleType ctRole, RoleType tRole) {
        roles = new Roles(createRole(ctRole), createRole(tRole));
    }

    private Role createRole(RoleType roleType) {
        return switch (roleType) {
            case LURKER -> new Lurker(this);
            case RIFLER -> new Rifler(this);
            case ANCHOR -> new Anchor(this);
            case ROTATOR -> new Rotator(this);
            case AWPER -> new Awper(this);
        };
    }

    public double getSkill(Match match){
        //zwraca nam skila danego gracza w danym meczu w danym etapie gry
        System.out.println(this.toString() + roles.getSkill(match));
        return roles.getSkill(match);
    }

    public void increaseSkill(Match match){
        //oddelegowane do roles
    }

    public void trainPlayer() {
        Role TRoleType = roles.getRoleByMatchStage(MatchStage.T);
        Role CtRoleType = roles.getRoleByMatchStage(MatchStage.T);
/*        addPoints(TRoleType);
        addPoints(CtRoleType);*/
    }

}

/*
*
*
*
* */