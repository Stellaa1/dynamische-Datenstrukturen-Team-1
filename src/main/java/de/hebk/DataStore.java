package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class DataStore implements Serializable {


     List<User> users = new List<>();

    boolean angemeldet;
    boolean ver;

    public List<User> getUsers() {
        return users;
    }

    public int searchForUser(String name){
        int index = -1;
        for (int i = 0; i< users.size(); i++){
            if (name.equals(users.get(i).getContext().getName())){
                index = i;
                //loadUser(i);
                break;
            }
        }
        return index;
    }



}