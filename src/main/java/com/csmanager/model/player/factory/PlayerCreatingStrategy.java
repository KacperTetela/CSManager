package com.csmanager.model.player.factory;

import com.csmanager.model.player.builder.Player;

public interface PlayerCreatingStrategy {
    Player createPlayer();
}
