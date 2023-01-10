package de.hebk;

public class Multiplayer {
    private Game game;
    private User currentPlayer;
    private User player1;
    private User player2;
    private GameSettings player1Settings;
    private GameSettings player2Settings;
    private int fIndex1 = 0;
    private int fIndex2 = 0;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(User currentPlayer) {
        this.currentPlayer = currentPlayer;
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

    public int getfIndex1() {
        return fIndex1;
    }

    public void setfIndex1(int fIndex1) {
        this.fIndex1 = fIndex1;
    }

    public int getfIndex2() {
        return fIndex2;
    }

    public void setfIndex2(int fIndex2) {
        this.fIndex2 = fIndex2;
    }
}