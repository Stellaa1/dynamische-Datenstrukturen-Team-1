package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private String profilePicture = "src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG";
    private List<String> achievements = new List<>();
    private int points, reversePoints = 0;
    private int played, won, lost = 0;
    private int played_Reverse, won_Reverse, lost_Reverse = 0;


    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getProfilePicture(){
        return profilePicture;
    }

    public List<String> getAchievements(){
        return achievements;
    }

    public void setName(String n){
        name = n;
    }

    public void setPassword(String p){
        password = p;
    }

    public void setProfilePicture(String p){
        profilePicture = p;
    }

    public void setAchievements(List<String> a){
        achievements = a;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getReversePoints() {
        return reversePoints;
    }

    public void setReversePoints(int reversePoints) {
        this.reversePoints = reversePoints;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getPlayed_Reverse() {
        return played_Reverse;
    }

    public void setPlayed_Reverse(int played_Reverse) {
        this.played_Reverse = played_Reverse;
    }

    public int getWon_Reverse() {
        return won_Reverse;
    }

    public void setWon_Reverse(int won_Reverse) {
        this.won_Reverse = won_Reverse;
    }

    public int getLost_Reverse() {
        return lost_Reverse;
    }

    public void setLost_Reverse(int lost_Reverse) {
        this.lost_Reverse = lost_Reverse;
    }
}