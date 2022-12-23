package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private String profilePicture = "src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG";
    private List<String> achievements = new List<>();

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

}
