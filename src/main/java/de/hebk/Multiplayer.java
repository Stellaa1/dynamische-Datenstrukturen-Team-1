package de.hebk;

public class Multiplayer {
    Game game;
    User player1;
    User player2;
    GameSettings player1Settings;
    GameSettings player2Settings;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public GameSettings getPlayer1Settings() {
        return player1Settings;
    }

    public void setPlayer1Settings(GameSettings player1Settings) {
        this.player1Settings = player1Settings;
    }

    public GameSettings getPlayer2Settings() {
        return player2Settings;
    }

    public void setPlayer2Settings(GameSettings player2Settings) {
        this.player2Settings = player2Settings;
    }
}