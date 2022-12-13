package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class DataStore implements Serializable {
    List<String> names;
    List<String> passwords;
    List<List<String>> achievements;

    boolean angemeldet;
    boolean ver;

    public int searchForUser(String name){
        int index = -1;
        for (int i = 0; i< names.size(); i++){
            if (name.equals(names.get(i))){
                index = i;
                loadUser(i);
                break;
            }
        }
        return index;
    }

    public void loadUser(int index){

    }
}