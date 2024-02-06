package com.csmanager.controller.career;

import com.csmanager.model.startingLineUp.LineUp;
import com.csmanager.model.*;
import com.csmanager.model.startingLineUp.LineUpPlayer;
import com.csmanager.model.startingLineUp.Role;
import com.github.javafaker.Faker;

import java.util.*;

public class CareerService {
    public void start() {
        try {
            PlayerCreator playerCreator = new PlayerCreator();
            Team myTeam = new Team("MyTeam", playerCreator.getPlayers(6));
            System.out.println(myTeam);
            System.out.println("-----");
            ShopCreator shopCreator = new ShopCreator();
            TournamentCreator tournamentCreator = new TournamentCreator();


            LineUp lineUp1 = manuallyCreateLineUp(myTeam);
            LineUp lineUp2 = autoCreateLineUp();

            System.out.println("\nYour lineup is: \n" + lineUp2);
            Match match = new Match(myTeam, lineUp1, lineUp2);
            System.out.println(myTeam.getPlayers().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LineUp manuallyCreateLineUp(Team myTeam) {
        LineUp lineUp = new LineUp();
        try {
            myTeam.getPlayers().forEach(System.out::println);
            System.out.println();
            for (int i = 0; i < 5; i++) {
                System.out.println("Write name of players which you want to add to your lineup\n");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();

                Optional<Player> playerOptional = myTeam.findPlayerByName(name);
                if (playerOptional.isEmpty()) {
                    System.out.println("Player not found or Player already taken");
                    i--;
                    continue;
                }

                System.out.println("Select roles T for " + name + "\n rifler=0 lurker=1 awp=2");
                int tRoleVal = scanner.nextInt();
                System.out.println("Select roles CT for " + name + "\n anchor=0 rotator=1 awp=2");
                int ctRoleVal = scanner.nextInt();

                Role tRole;
                if (tRoleVal == 0) {
                    tRole = Role.RIFLER;
                } else if (tRoleVal == 1) {
                    tRole = Role.LURKER;
                } else {
                    tRole = Role.AWPER;
                }

                Role ctRole;
                if (ctRoleVal == 0) {
                    ctRole = Role.ANCHOR;
                } else if (ctRoleVal == 1) {
                    ctRole = Role.ROTATOR;
                } else {
                    ctRole = Role.AWPER;
                }
                lineUp.addPlayer(new LineUpPlayer(playerOptional.get(), ctRole, tRole));
                myTeam.removePlayer(playerOptional.get());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lineUp;
    }

    private LineUp autoCreateLineUp() {
        Faker faker = new Faker();
        LineUp lineUp = new LineUp();
        Role[] rolesCT = {Role.ANCHOR, Role.ANCHOR, Role.ROTATOR, Role.ROTATOR, Role.AWPER};
        Role[] rolesT = {Role.LURKER, Role.LURKER, Role.RIFLER, Role.RIFLER, Role.AWPER};
        for (int i = 0; i < 5; i++) {
            lineUp.addPlayer(new LineUpPlayer(new Player(faker.name().name(), PotentialScope.NOOB), rolesCT[i], rolesT[i]));
        }
        return lineUp;
    }
}
