package com.csmanager.controller.career;

import com.csmanager.model.lineUp.*;
import com.csmanager.model.*;
import com.csmanager.utils.Utils;

public class CareerService {
    private Team myTeam;
    private LineUp currentPlayerLineUp;

    public CareerService() {
        this.myTeam = startCareer();
        buildLineUp();
        for (int i = 0; i < 2; i++) {
            playMatch();
        }
    }

    /**
     * Wyswietla interfejs gry czyli ilosc pieniedzy, graczy i zapytaja co robic dalej czy kupowacGraczy() lub bootcampy.
     * Lub zagrac turniej czyli ciag paru meczy.
     * W kazdym meczu mamy byc poproszeni o wybranie graczy do LineUp oraz nadanie im roli
     */
    public Team startCareer() {
        PlayerCreator playerCreator = new PlayerCreator();
        Team myTeam = new Team(Utils.askAboutString("Please name your team"), playerCreator.getPlayers(6));
        System.out.println(myTeam);
        return myTeam;
    }

    private void buildLineUp() {
        try {
            ManuallyCreateLineUp manuallyCreateLineUp = new ManuallyCreateLineUp(myTeam);
            this.currentPlayerLineUp = manuallyCreateLineUp.getLineUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playMatch() {
        AutoLineUpCreator autoLineUpCreator = new AutoLineUpCreator();
        LineUp lineUp2 = autoLineUpCreator.getLineUp();

        Match match = new Match(myTeam, currentPlayerLineUp, lineUp2);
        System.out.println(myTeam.getPlayers().toString());
    }
}
