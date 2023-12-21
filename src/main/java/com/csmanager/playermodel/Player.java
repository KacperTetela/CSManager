package com.csmanager.playermodel;

import com.csmanager.carrer.startingLineUp.Role;
import java.util.*;

public class Player {
    //id gracza potrzebne do bazy danych
    private Long id;
    //dane gracza
    private String name;
    private int age;
    //doswiadczenie
    private int daysInTeams;
    private double consistency;
    private Map<Role, Double> potential = new HashMap<>();
    private Map<Role, Double> rolePoints = new HashMap<>();

    public Player(String name) {
        this.name = name;
        Role.getPotentialRoles().forEach(role -> potential.put(role, Math.random()*0.5));
        Arrays.stream(Role.values()).forEach(role -> rolePoints.put(role, Math.random()*0.25));
        consistency = Math.random()*0.5;
        daysInTeams = (int)(Math.random()*1000);
        age = (int)(Math.random()*20 + 15);
        //HomeWork - drugi parametr musi polegac na wartosci ustawionej w pierwszym, jesli pierwszy parametr duzy to, drugi maly
        //Zeby suma mnoznika nie mogla przekroczyc okreslonej warotsci np. 1
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", daysInTeams=" + daysInTeams +
                ", consistency=" + consistency +
                ", potential=" + potential +
                ", rolePoints=" + rolePoints +
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