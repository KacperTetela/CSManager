package com.csmanager.model.player.player.creatingStrategy;

import com.csmanager.model.player.player.Player;
import com.csmanager.model.player.player.PlayerBuilder;
import com.csmanager.model.player.performance.Difficulty;
import com.csmanager.utils.NicknamesFaker;

public class DefaultCreatingStrategy implements PlayerCreatingStrategy {
    @Override
    public Player createPlayer() {
        PlayerBuilder playerBuilder = new PlayerBuilder().name(NicknamesFaker.getNickname())
                .difficulty(Difficulty.getInstance().getValue());
        return playerBuilder.build();
    }
}