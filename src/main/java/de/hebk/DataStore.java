package de.hebk;

import de.hebk.model.list.List;

import java.io.Serializable;

public class DataStore implements Serializable {


    public List<User> users = new List<>();
    public List<User> getUsers() {
        return users;
    }

    public int searchForUser(String name){
        int index = -1;
        for (int i = 0; i< users.size(); i++){
            if (name.equals(users.get(i).getContext().getName())){
                index = i;
                break;
            }
        }
        return index;
    }
}