package com.csmanager.model.roster.rosterLock;

import com.csmanager.model.player.player.Player;
import com.csmanager.model.roster.Roster;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

import java.util.Optional;

public class RosterPlayersService {
    public void select(Team myTeam, Roster roster) {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println();
            String name = Utils.askAboutString("Write name of players which you want to add to your roster");

            Optional<Player> playerOptional = myTeam.findPlayerNotBusyByName(name);
            if (playerOptional.isEmpty()) {
                System.out.println("Player not found or Player already taken");
                i--;
                continue;
            }
            Player player = playerOptional.get();
            roster.addPlayer(player);
            player.setBusy(true);
        }
    }
}