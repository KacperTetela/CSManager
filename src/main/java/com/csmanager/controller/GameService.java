package com.csmanager.controller;

import com.csmanager.model.match.MatchRules;
import com.csmanager.model.player.player.creatingStrategy.CreatingStrategyService;
import com.csmanager.model.roster.*;
import com.csmanager.model.match.Match;
import com.csmanager.model.roster.rosterLock.RosterLockFacade;
import com.csmanager.model.shop.coachPerks.Profitable;
import com.csmanager.model.shop.coachPerks.StatsVisibility;
import com.csmanager.model.shop.market.BuyPlayer;
import com.csmanager.model.team.Team;
import com.csmanager.utils.Utils;

public class GameService {
    private Team myTeam;
    private Roster playerRoster;
    private CreatingStrategyService creatingStrategyService;
    private BuyPlayer buyPlayer;
    private MatchRules matchRules;

    public GameService() {
    }

    public void startGame() {
        this.creatingStrategyService = new CreatingStrategyService();
        this.myTeam = createTeam();
        this.buyPlayer = new BuyPlayer(myTeam);
        matchRules = new MatchRules();
        do {
            prepareLineup();
            //buyPerks();
            Match match = prepareMatch(creatingStrategyService);
            match.playMatch();
            //branie pod uwagę progresssu
            if (Utils.askAboutBoolean("Do you want to buy a new player?")) {
                buyPlayer.launch();
            }
            buyPerks();

        } while (true); // warunek konca
    }

    private void buyPerks() {
/*        if (Utils.askAboutBoolean("")) {

        }*/
        StatsVisibility statsVisibility = new StatsVisibility(matchRules);
        myTeam.buyPerk(statsVisibility);
    }

    /**
     * Wyswietla interfejs gry czyli ilosc pieniedzy, graczy i zapytaja co robic dalej czy kupowacGraczy() lub bootcampy.
     * Lub zagrac turniej czyli ciag paru meczy.
     * W kazdym meczu mamy byc poproszeni o wybranie graczy do LineUp oraz nadanie im roli
     * <p>
     * Zmienic tak zeby bez wzgledu czy wpiszemy BYALI czy byali z malej bylo traktowane jako to samo
     */
    public Team createTeam() {
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
        boolean change = Utils.askAboutBoolean("Do you want to change roster?");
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

    private Match prepareMatch(CreatingStrategyService creatingStrategyService) {
        AutoRosterCreator autoRosterCreator = new AutoRosterCreator(creatingStrategyService);
        Roster computerRoster = autoRosterCreator.getRoster();
        return new Match(myTeam, playerRoster, computerRoster, matchRules);
    }

}
