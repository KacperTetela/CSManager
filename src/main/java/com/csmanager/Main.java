package com.csmanager;

import com.csmanager.carrer.ShopCreator;
import com.csmanager.carrer.Team;
import com.csmanager.carrer.TournamentCreator;
import com.csmanager.carrer.startingLineUp.Role;
import com.csmanager.playermodel.LineUpPlayer;
import com.csmanager.playermodel.Player;

public class Main {
    public static void main(String[] args) {

        //System.out.println(Role.getSide());
        System.out.println(Role.ANCHOR.getSide());
        System.out.println();

        Role.getPotentialRoles();


        //inicjuje wszystkich graczy z kolejki, przekonwertowanej na liste
        PlayerCreator playerCreator = new PlayerCreator();
//        Queue<Player> playersQueue = playerCreator.getAllPlayers();
//        List<Player> players = new ArrayList<>(playersQueue);

        //inicjuje druzyne
        Team myTeam = new Team("MyTeam", playerCreator.getPlayers(6));
        System.out.println(myTeam);

        //inicjuje sklep, przechodzi do menu sklepu
        ShopCreator shopCreator = new ShopCreator();
        //System.out.println(shopCreator);

        //inicjuje turniej, przechodzi do menu turnieju/ów
        TournamentCreator tournamentCreator = new TournamentCreator();
        //System.out.println(tournamentCreator);

        LineUp lineUp = new LineUp();
        Player player = new Player("Janusz");
        lineUp.addPlayer(new LineUpPlayer(player, Role.ANCHOR, Role.LURKER));

        //inicjuje sklad, przechodzi do wybierania skladu, graczy na poszczegolne pozycje
        //StartingLineUp startingLineUp = new StartingLineUp(myTeam);

        //inicjuje mecz, przechodzi do symulacji meczu lub do docelowego wyniku
        //Match match = new Match(startingLineUp);

    }
}
