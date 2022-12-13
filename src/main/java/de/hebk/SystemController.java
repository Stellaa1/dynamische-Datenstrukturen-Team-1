package de.hebk;

import java.io.*;

public class SystemController {

    DataStore dataStore = new DataStore();
    User user = new User();

    public void saveData() {
        try {
            FileOutputStream f = new FileOutputStream("ver.dat");
            BufferedOutputStream b = new BufferedOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(b);

            int index = dataStore.searchForUser(user.getName());

            if (index == -1){
                dataStore.names.append(user.getName());
                dataStore.passwords.append(user.getPassword());
                dataStore.achievements.append(user.getAchievements());

            } else {
                dataStore.names.get(index).setContext(user.getName());
                dataStore.passwords.get(index).setContext(user.getPassword());
                dataStore.achievements.get(index).setContext(user.getAchievements());
            }

            //saveCards();

            o.writeObject(dataStore);
            o.close();

        } catch (IOException d) {
            d.printStackTrace();
        }
    }


    public void loadData() {
        try {

            FileInputStream f2 = new FileInputStream("ver.dat");
            BufferedInputStream b2 = new BufferedInputStream(f2);
            ObjectInputStream obj2 = new ObjectInputStream(b2);

            DataStore dataStore = (DataStore) obj2.readObject();

            int index = dataStore.searchForUser(user.getName());

            if (index == -1){
                System.out.println("Nicht gefunden");
                return;

            } else {
                user.setName(dataStore.names.get(index).getContext());
                user.setPassword(dataStore.passwords.get(index).getContext());
                user.setAchievements(dataStore.achievements.get(index).getContext());
            }


            //for (int i = 0; i < 10; i++) {
                //karten[i] = dataStore.karten[i];
           // }

            //for (int i = 0; i < 10; i++) {
                //if (!dataStore.karten[i].karte_Name.equals("N/A")) {
                  //  super.search_Results[i + 1] = dataStore.karten[i].karte_Name;
                //}
            //}

            obj2.close();

        } catch (IOException d) {
            d.printStackTrace();
        } catch (ClassNotFoundException d2) {
            d2.printStackTrace();
        } catch (Exception m) {

        }
    }

}
