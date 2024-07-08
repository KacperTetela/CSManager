package com.csmanager.model.player.player;

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
    private StatsManager statsManager;
    private boolean busy;
    private int marketValue;

    /**
     * stworzyc nowa klase PerformanceScope ktora bedzie raz na mecz tworzyla realny perforamnce gracza za pomoca jakiejs skali,
     * biorac pod uwage rolePointsy oraz bedzie warunkowalo powtarzalnosc na podstawie doswiadczenia liczonego w latach i dniach w druzynir
     */
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

    public Player() {
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    /**
     * getAge and setAge must be initialized for the Jackson library to function properly.
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public StatsManager getStatsManager() {
        return statsManager;
    }

    public String getView(int areStatsEnable) {
        String view = name +
                "  age:" + age + "\n stats = ";
        for (RoleStats roleStats : statsManager.getAllRoleStats()) {
            view += roleStats.getView(areStatsEnable);
        }
        return view;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", daysInTeams=" + daysInTeams +
                ", consistency=" + consistency +
                ", rolesBoth=" + rolesBoth +
                ", statsManager=" + statsManager +
                ", MarketValue=" + marketValue +
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