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
            int index = Utils.askAboutInt("\nWrite index of players which you want to add to your roster");
            if (index > myTeam.getPlayers().size() || index < 1) {
                System.out.println("Player index not found");
                i--;
                continue;
            }
            String name = myTeam.getPlayers().get(index - 1).getName();
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