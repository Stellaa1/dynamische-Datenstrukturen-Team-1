package de.hebk;

import de.hebk.model.list.List;

public class User {
    private String name;
    private String password;
    private List<String> achievements = new List<>();

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
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

    public void setAchievements(List<String> a){
        achievements = a;
    }

}
