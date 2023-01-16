package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class User implements Serializable {

    private String joinDate;
    private String name;
    private String password;
    private String profilePicture = "src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG";
    private List<String> achievements;
    private int points, reversePoints = 0;
    private int played, won, lost = 0;
    private int played_Reverse, won_Reverse, lost_Reverse = 0;
    private List<Integer> favorite_subjects;
    private int used_Joker_Audience, used_Joker_FiftyFifty, used_Joker_Call, used_Joker_Revive = 0;

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

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

    public List<Integer> getFavorite_subjects() {
        return favorite_subjects;
    }

    public void setFavorite_subjects(List<Integer> favorite_subjects) {
        this.favorite_subjects = favorite_subjects;
    }

    public int getUsed_Joker_Audience() {
        return used_Joker_Audience;
    }

    public void setUsed_Joker_Audience(int used_Joker_Audience) {
        this.used_Joker_Audience = used_Joker_Audience;
    }

    public int getUsed_Joker_FiftyFifty() {
        return used_Joker_FiftyFifty;
    }

    public void setUsed_Joker_FiftyFifty(int used_Joker_FiftyFifty) {
        this.used_Joker_FiftyFifty = used_Joker_FiftyFifty;
    }

    public int getUsed_Joker_Call() {
        return used_Joker_Call;
    }

    public void setUsed_Joker_Call(int used_Joker_Call) {
        this.used_Joker_Call = used_Joker_Call;
    }

    public int getUsed_Joker_Revive() {
        return used_Joker_Revive;
    }

    public void setUsed_Joker_Revive(int used_Joker_Revive) {
        this.used_Joker_Revive = used_Joker_Revive;
    }
}