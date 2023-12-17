package com.csmanager.playermodel;

import com.csmanager.carrer.startingLineUp.CTSideRoles.CTSideRole;
import com.csmanager.carrer.startingLineUp.TSideRoles.TSideRole;

import java.util.Objects;

public class Player {
    //id gracza potrzebne do bazy danych
    private Long id;
    //dane gracza
    private String name;
    private int age;
    //doswiadczenie
    private int daysInTeams;
    private float consistency;
    //potencjal wzgledem roli
    private float potentialAsRifler;
    private float potentialAsSniper;
    private float potentialAsLurker;
    private float potentialAsIGL;
    //role w druzynie
    private TSideRole tSideRole;
    private CTSideRole ctSideRole;
    //zdolnosci riflerskie
    private float agressionAsRiflerAsRiflerPoints;
    private float defensivnessAsRiflerPoints;
    //zdolnosci przecinania rotacji
    private float lurkingPoints;
    //zdolnosci strzeleckie ze snajperki
    private float snipingPoints;

    //zdolnosci przywodcze
    private float leadingAsIGL;

    public Player(String name, int experience, int skillLevel) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
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
}
