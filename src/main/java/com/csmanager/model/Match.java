package com.csmanager.model;

import com.csmanager.model.lineup.Lineup;

public class Match {
    private Team myTeam;
    private Lineup playerLineup;
    private Lineup computerLineup;
    private Stage stage;
    /**
     * The score int array is initialized to store the match result for two teams, respectively for
     * playerLineup, computerLineup
     * score[0] = playerScore
     * score[1] = computerScore
     */
    private int[] score;

    public Match(Team myTeam, Lineup playerLineup, Lineup computerLineup) {
        this.myTeam = myTeam;
        this.playerLineup = playerLineup;
        this.computerLineup = computerLineup;
        score = new int[2];
        stage = Stage.CT;
    }

    public void playMatch() {
        simulateMatch();
        displayMatchResult();
        applyProgress();
    }


    private void simulateMatch() { //TODO musimy to powtorzyc dla 1 rundy, 2 rundy i END

        /*
        if(STAGE.CT) {
        
        }

                if(STAGE.T) {

        }

                if(STAGE.END) {
        }
         */

        double playerSkill = playerLineup.getLineUpSkillLevel(this);
        double computerSkill = computerLineup.getLineUpSkillLevel(this);
        System.out.println(playerSkill);
        System.out.println(computerSkill);
        if (playerSkill > computerSkill) {
            score[0] = 16;
            score[1] = 0;
        } else if (playerSkill < computerSkill) {
            score[0] = 0;
            score[1] = 16;
        } else {
            score[0] = 15;
            score[1] = 15;
        }
    }

    private void displayMatchResult() {
        System.out.println("\nLineUp 1: " + score[0] + " LineUp 2: " + score[1]);
        if (score[0] > score[1]) {
            System.out.println("You win\n");
        } else if (score[0] < score[1]) {
            System.out.println("You lose\n");
        } else {
            System.out.println("Draw!\n");
        }
    }

    public Stage getStage() {
        return stage;
    }

    private void applyProgress() {
        if (score[0] > score[1]) {
            myTeam.addMoney(100);
        }
        playerLineup.trainPlayers();
    }
}



/*

Gracz - 2 role.
Roles - ma te dwie role i zarzadza dostepami do nich i przyjmuje mecz

* rozegraj 1 połowę
* rozegraj 2 połowę
* podlicz skille
*
*
*
*
*
*
*
* */
