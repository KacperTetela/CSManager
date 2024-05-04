package com.csmanager.controller;

import com.csmanager.model.player.player.creatingStrategy.CreatingStrategyService;
import com.csmanager.model.roster.*;
import com.csmanager.model.match.Match;
import com.csmanager.model.roster.rosterLock.RosterLockFacade;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

public class GameService {
    private Team myTeam;
    private Roster playerRoster;

    public GameService() {
    }

    public void startGame() {
        this.myTeam = createTeam();
        do {
            prepareLineup();
            Match match = prepareMatch();
            match.playMatch();
            //branie pod uwagę progresssu
            //wydaj zarobione pieniądze
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
        CreatingStrategyService creatingStrategyService = new CreatingStrategyService();
        return new Team(Utils.askAboutString("Please name your team"), creatingStrategyService.getStarterPlayers());
    }

    /**
     * buduje LineUp oraz currentPLayerLineUp za pomoca metody buildLineUP
     */

    private void prepareLineup() {
        if (playerRoster == null) {
            playerRoster = buildNewLineUp();
            return;
        }
        boolean change = Utils.askAboutboolean("Do you want to change roster?");
        if (change) {
            playerRoster.closeRoster();
            playerRoster = buildNewLineUp();
        }

    }

    private Roster buildNewLineUp() {
        System.out.println(myTeam);
        RosterLockFacade manuallyCreateLineUp = new RosterLockFacade(myTeam);
        manuallyCreateLineUp.createRoster();
        return manuallyCreateLineUp.getRoster();
    }

    private Match prepareMatch() {
        AutoRosterCreator autoRosterCreator = new AutoRosterCreator();
        Roster computerRoster = autoRosterCreator.getRoster();
        return new Match(myTeam, playerRoster, computerRoster);
    }

}
