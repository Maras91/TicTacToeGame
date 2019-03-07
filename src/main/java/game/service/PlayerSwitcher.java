package game.service;

import game.model.Player;

public class PlayerSwitcher {
    private Player player;
    private int counter;

    public PlayerSwitcher(Player player) {
        this.player = player;
        counter=0;
    }
    public void switchPlayer() {
        if (player== Player.o) {
            player=Player.x;
        } else {
            player=Player.o;
        }
    }

    public Player getPlayer() {
        return player;
    }
}
