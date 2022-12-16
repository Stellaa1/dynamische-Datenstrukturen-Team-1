package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class DataStore implements Serializable {


     List<String> names = new List<>();

    static List<String> passwords = new List<>();
    static List<List<String>> achievements = new List<>();

    boolean angemeldet;
    boolean ver;

    public  List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        names = names;
    }

    public static List<String> getPasswords() {
        return passwords;
    }

    public static void setPasswords(List<String> passwords) {
        DataStore.passwords = passwords;
    }

    public static List<List<String>> getAchievements() {
        return achievements;
    }

    public static void setAchievements(List<List<String>> achievements) {
        DataStore.achievements = achievements;
    }

    public int searchForUser(String name){
        int index = -1;
        for (int i = 0; i< names.size(); i++){
            if (name.equals(names.get(i).getContext())){
                index = i;
                loadUser(i);
                break;
            }
        }
        return index;
    }

    public static void loadUser(int index){

    }
}