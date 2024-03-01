package com.csmanager.model;

import com.csmanager.model.lineUp.LineUp;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private Team myTeam;
    private LineUp playerLineUp;
    private LineUp computerLineUp;
    private int playerScore;
    private int computerScore;

    public Match(Team myTeam, LineUp playerLineUp, LineUp computerLineUp) {
        this.myTeam = myTeam;
        this.playerLineUp = playerLineUp;
        this.computerLineUp = computerLineUp;
        playerScore = 0;
        computerScore = 0;
    }

    public void playMatch() {
        simulateMatch();
        displayMatchResult();
        applyProgress();
    }


    private void simulateMatch() {
        double playerSkill = playerLineUp.getLineUpSkillLevel();
        double computerSkill = computerLineUp.getLineUpSkillLevel();
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
        playerLineUp.trainPlayers();
    }
}
