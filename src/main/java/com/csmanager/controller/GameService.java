package com.csmanager.controller;

import com.csmanager.model.lineup.*;
import com.csmanager.model.*;
import com.csmanager.model.player.PlayerFactory;
import com.csmanager.utils.Utils;

public class GameService {
    private Team myTeam;
    private Lineup playerLineup;

    public GameService() {
    }

    public void startGame() {
        this.myTeam = createTeam();
        do {
            //wydaj zarobione pieniądze
            prepareLineup();
            Match match = prepareMatch();
            match.playMatch();
            //branie pod uwagę progresssu
        } while (true); // warunek konca
    }

    /**
     * Wyswietla interfejs gry czyli ilosc pieniedzy, graczy i zapytaja co robic dalej czy kupowacGraczy() lub bootcampy.
     * Lub zagrac turniej czyli ciag paru meczy.
     * W kazdym meczu mamy byc poproszeni o wybranie graczy do LineUp oraz nadanie im roli
     * <p>
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
        if (playerLineup == null) {
            playerLineup = buildNewLineUp();
            return;
        }
        boolean change = Utils.askAboutboolean("Do you want to change lineup?");
        if (change) {
            playerLineup.closeLineup();
            playerLineup = buildNewLineUp();
        }

    }

    private Lineup buildNewLineUp() {
        System.out.println(myTeam);
        ManuallyCreateLineup manuallyCreateLineUp = new ManuallyCreateLineup(myTeam);
        manuallyCreateLineUp.createLineUp();
        return manuallyCreateLineUp.getLineUp();
    }

    private Match prepareMatch() {
        AutoLineupCreator autoLineUpCreator = new AutoLineupCreator();
        Lineup computerLineup = autoLineUpCreator.getLineUp();
        return new Match(myTeam, playerLineup, computerLineup);
    }

}
