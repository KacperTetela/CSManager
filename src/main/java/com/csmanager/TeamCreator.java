package com.csmanager;

public class TeamCreator {
    private PlayerCreator playerCreator;

    public TeamCreator(PlayerCreator playerCreator) {
        this.playerCreator = playerCreator;
        createNewTeam();
    }

    private void createNewTeam() {
        for (int i = 0; i < 5; i++) {
            playerCreator.deletePlayer(playerCreator.getFreePlayer().getName());
        }
        Team team = new Team();
    }

}
