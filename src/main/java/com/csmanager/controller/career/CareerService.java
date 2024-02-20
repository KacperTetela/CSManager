package com.csmanager.controller.career;

import com.csmanager.model.lineUp.*;
import com.csmanager.model.*;
import com.csmanager.utils.Utils;

public class CareerService {
    private Team myTeam;
    private LineUp currentPlayerLineUp;

    public CareerService() {
        this.myTeam = startCareer();
        for (int i = 0; i < 3; i++) {
            playMatch();
        }
    }
    /**
     * Wyswietla interfejs gry czyli ilosc pieniedzy, graczy i zapytaja co robic dalej czy kupowacGraczy() lub bootcampy.
     * Lub zagrac turniej czyli ciag paru meczy.
     * W kazdym meczu mamy byc poproszeni o wybranie graczy do LineUp oraz nadanie im roli
     *
     * Zmienic tak zeby bez wzgledu czy wpiszemy BYALI czy byali z malej bylo traktowane jako to samo
     */
    public Team startCareer() {
        PlayerCreator playerCreator = new PlayerCreator();
        Team myTeam = new Team(Utils.askAboutString("Please name your team"), playerCreator.getPlayers(6));
        return myTeam;
    }

    private void buildLineUp() {
        try {
            System.out.println(myTeam);
            ManuallyCreateLineUp manuallyCreateLineUp = new ManuallyCreateLineUp(myTeam);
            this.currentPlayerLineUp = manuallyCreateLineUp.getLineUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * buduje LineUp oraz currentPLayerLineUp za pomoca metody buildLineUP
     */
    private void playMatch() {
        AutoLineUpCreator autoLineUpCreator = new AutoLineUpCreator();
        LineUp lineUp2 = autoLineUpCreator.getLineUp();
        buildLineUp();
        Match match = new Match(myTeam, currentPlayerLineUp, lineUp2);
    }
}
