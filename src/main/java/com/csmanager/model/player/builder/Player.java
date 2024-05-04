package com.csmanager.model.player.builder;

import com.csmanager.model.match.Match;
import com.csmanager.model.match.MatchStage;
import com.csmanager.model.player.roles.roleType.RoleType;
import com.csmanager.model.player.roles.roleType.Side;
import com.csmanager.model.player.roles.roles.*;

import java.util.*;

public class Player {
    private String name;
    private int age;
    private int daysInTeams;
    private double consistency;
    private RolesBoth rolesBoth;
    /**
     * stworzyc nowa klase PerformanceScope ktora bedzie raz na mecz tworzyla realny perforamnce gracza za pomoca jakiejs skali,
     * biorac pod uwage rolePointsy oraz bedzie warunkowalo powtarzalnosc na podstawie doswiadczenia liczonego w latach i dniach w druzynir
     */
    private StatsManager statsManager;
    private boolean busy;

    Player(String name, double difficulty) {
        this.name = name;
        statsManager = new StatsManager();
        RoleType.getRoles().forEach(roleType -> {
            PlayerPointsScope playerPointsScope;
            if (Math.random() > 0.5) {
                playerPointsScope = PlayerPointsScope.HIGH;
            } else {
                playerPointsScope = PlayerPointsScope.LOW;
            }
            statsManager.add(new RoleStats(roleType, playerPointsScope.rollPotential(),
                    playerPointsScope.rollStats(difficulty)));
        });

        consistency = 0.5 + Math.random() * 0.5;
        daysInTeams = (int) (Math.random() * 1000);
        age = (int) (Math.random() * 20 + 15);
    }

    public Player(String name, double[][] roleTypeValues) {
        this.name = name;
        statsManager = new StatsManager();
        RoleType.getRoles().forEach(roleType -> {
            int incrementValue = 0;
            statsManager.add(new RoleStats(roleType, roleTypeValues[incrementValue][0], roleTypeValues[incrementValue][1]));
            incrementValue++;
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

    public StatsManager getStatsManager() {
        return statsManager;
    }

    @Override
    public String toString() {
        return "\n" + name +
                "\nstats=" + (statsManager.getAllRoleStats());
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
            statsManager.increaseSkillByPotential(roleType);
        }
    }

    public void setRoles(RoleType ctRole, RoleType tRole) {
        rolesBoth = new RolesBoth(createRole(ctRole), createRole(tRole));
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

    public double getSkill(Match match) {
        //zwraca nam skila danego gracza w danym meczu w danym etapie gry
        System.out.println(this.toString() + rolesBoth.getSkill(match));
        return rolesBoth.getSkill(match);
    }

    public double getRolePoints(RoleType roleType) {
        return statsManager.getRolePoints(roleType);
    }

    public double getPotentialPoints(RoleType roleType) {
        return statsManager.getPotentialPoints(roleType);
    }

    public void increaseSkill(Match match) {
        //oddelegowane do rolesBoth
    }

    public void trainPlayer() {
        Role TRoleType = rolesBoth.getRoleByMatchStage(MatchStage.T);
        Role CtRoleType = rolesBoth.getRoleByMatchStage(MatchStage.T);
/*        addPoints(TRoleType);
        addPoints(CtRoleType);*/
    }



}