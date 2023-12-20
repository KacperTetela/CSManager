package com.csmanager;

import com.csmanager.carrer.Shop;
import com.csmanager.carrer.ShopCreator;
import com.csmanager.carrer.Team;
import com.csmanager.carrer.TournamentCreator;
import com.csmanager.playermodel.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        //inicjuje wszystkich graczy z kolejki, przekonwertowanej na liste
        PlayerCreator playerCreator = new PlayerCreator();
        Queue<Player> playersQueue = playerCreator.getAllPlayers();
        List<Player> players = new ArrayList<>(playersQueue);

        //inicjuje druzyne
        Team myTeam = new Team("MyTeam", players);
        //System.out.println(myTeam);

        //inicjuje sklep, przechodzi do menu sklepu
        ShopCreator shopCreator = new ShopCreator();
        //System.out.println(shopCreator);

        //inicjuje turniej, przechodzi do menu turnieju/ów
        TournamentCreator tournamentCreator = new TournamentCreator();
        //System.out.println(tournamentCreator);

        //inicjuje sklad, przechodzi do wybierania skladu, graczy na poszczegolne pozycje
        //StartingLineUp startingLineUp = new StartingLineUp(myTeam);

        //inicjuje mecz, przechodzi do symulacji meczu lub do docelowego wyniku
        //Match match = new Match(startingLineUp);

    }
}
