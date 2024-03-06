package com.csmanager.model;

import com.csmanager.model.lineup.Lineup;

public class Match {
    private Team myTeam;
    private Lineup playerLineup;
    private Lineup computerLineup;
    private int playerScore;
    private int computerScore;

    public Match(Team myTeam, Lineup playerLineup, Lineup computerLineup) {
        this.myTeam = myTeam;
        this.playerLineup = playerLineup;
        this.computerLineup = computerLineup;
        playerScore = 0;
        computerScore = 0;
    }

    public void playMatch() {
        simulateMatch();
        displayMatchResult();
        applyProgress();
    }


    private void simulateMatch() {
        double playerSkill = playerLineup.getLineUpSkillLevel();
        double computerSkill = computerLineup.getLineUpSkillLevel();
        System.out.println(playerSkill);
        System.out.println(computerSkill);
        if (playerSkill > computerSkill) {
            playerScore = 16;
            computerScore = 0;
        } else if (playerSkill < computerSkill) {
            playerScore = 0;
            computerScore = 16;
        } else {
            playerScore = 15;
            computerScore = 15;
        }
    }

    private void displayMatchResult() {
        System.out.println("\nLineUp 1: " + playerScore + " LineUp 2: " + computerScore);
        if (playerScore > computerScore) {
            System.out.println("You win\n");
        } else if (playerScore < computerScore) {
            System.out.println("You lose\n");
        } else {
            System.out.println("Draw!\n");
        }
    }

    private void applyProgress() {
        if (playerScore > computerScore) {
            myTeam.addMoney(100);
        }
        playerLineup.trainPlayers();
    }
}
