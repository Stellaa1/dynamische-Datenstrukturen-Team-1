package de.hebk;

public class GameSettings {

    private Joker joker = new Joker();
    private String gameMode = "Normal";
    private int reward = 0;
    private int question_Amount = 10;
    private String category = "Allgemein";
    private int difficultyValue = 20;
    private int difficultyRange = 0;
    private int incrementValue = 2;
    private int incrementRange = 2;
    private String currency = "€";
    private boolean autoConfirm = false;

    public Joker getJoker() {
        return joker;
    }

    public void setJoker(Joker joker) {
        this.joker = joker;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getQuestion_Amount() {
        return question_Amount;
    }

    public void setQuestion_Amount(int question_Amount) {
        this.question_Amount = question_Amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDifficultyValue() {
        return difficultyValue;
    }

    public void setDifficultyValue(int difficultyValue) {
        this.difficultyValue = difficultyValue;
    }

    public int getDifficultyRange() {
        return difficultyRange;
    }

    public void setDifficultyRange(int difficultyRange) {
        this.difficultyRange = difficultyRange;
    }

    public int getIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(int incrementValue) {
        this.incrementValue = incrementValue;
    }

    public int getIncrementRange() {
        return incrementRange;
    }

    public void setIncrementRange(int incrementRange) {
        this.incrementRange = incrementRange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isAutoConfirm() {
        return autoConfirm;
    }

    public void setAutoConfirm(boolean autoConfirm) {
        this.autoConfirm = autoConfirm;
    }
}