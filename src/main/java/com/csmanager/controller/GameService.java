package com.csmanager.controller;

import com.csmanager.model.lineUp.*;
import com.csmanager.model.*;
import com.csmanager.model.player.PlayerFactory;
import com.csmanager.utils.Utils;

public class GameService {
    private Team myTeam;
    private LineUp playerLineUp;

    public GameService() {


    }

    public void startGame() {
        this.myTeam = createTeam();
        do {
            //wydaj zarobione pieniądze
            prepareLineup();
            Match match = prepareMatch();
            match.playMatch(); // draw
        //branie pod uwagę progresssu
        } while (true); // warunek konca
    }
    /**
     * Wyswietla interfejs gry czyli ilosc pieniedzy, graczy i zapytaja co robic dalej czy kupowacGraczy() lub bootcampy.
     * Lub zagrac turniej czyli ciag paru meczy.
     * W kazdym meczu mamy byc poproszeni o wybranie graczy do LineUp oraz nadanie im roli
     *
     * Zmienic tak zeby bez wzgledu czy wpiszemy BYALI czy byali z malej bylo traktowane jako to samo
     */
    public Team createTeam() {
        PlayerFactory playerFactory = new PlayerFactory();
        return new Team(Utils.askAboutString("Please name your team"), playerFactory.getPlayers(6));
    }

    /**
     * buduje LineUp oraz currentPLayerLineUp za pomoca metody buildLineUP
     */

    private void prepareLineup() {
        if (playerLineUp == null) {
           playerLineUp = buildNewLineUp();
           return;
        }
        boolean change = Utils.askAboutboolean("Do you want to change lineup?");
        if (change) {
            playerLineUp.closeLineup();
            playerLineUp = buildNewLineUp();
        }

    }

    private LineUp buildNewLineUp() {
            System.out.println(myTeam);
            ManuallyCreateLineUp manuallyCreateLineUp = new ManuallyCreateLineUp(myTeam);
            manuallyCreateLineUp.createLineUp();
           return manuallyCreateLineUp.getLineUp();
    }

    private Match prepareMatch() {
        AutoLineUpCreator autoLineUpCreator = new AutoLineUpCreator();
        LineUp computerLineUp = autoLineUpCreator.getLineUp();
        return new Match(myTeam, playerLineUp, computerLineUp);
    }

}
