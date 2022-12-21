package de.hebk;


import de.hebk.model.list.List;
import javafx.scene.control.TextField;

import java.io.*;

public class SystemController{

    String version = "";
    DataStore dataStore = new DataStore();


    static List<User> users = new List<>();

    public void saveData() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("DataStore.dat");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        System.out.println(users.toString());
        dataStore.users = users;

        objectOutputStream.writeObject(dataStore);
        objectOutputStream.close();
        System.out.println(version);

    }

    public void loadData() {
        try {

            FileInputStream fileInputStream = new FileInputStream("DataStore.dat");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

            DataStore data = (DataStore) objectInputStream.readObject();

            users = data.users;
            System.out.println(users.toString() + " users");

            objectInputStream.close();
            System.out.println(version);

        } catch (IOException d) {
            d.printStackTrace();
        } catch (ClassNotFoundException d2) {
            d2.printStackTrace();
        } catch (Exception m) {

        }
    }


    public String randomName() {
        Texts texts = new Texts();
        int x = (int) (Math.random() * 100);
        String s = "";
        if (x > 50) {
            x = (int) (Math.random() * 100);
            for (int a = 1; a < 3; a++) {
                s = s + texts.randomNames[x];
                x = (int) (Math.random() * 100);

            }
            System.out.println(s);
            return s;
        }

        if (x < 50) {
            x = (int) (Math.random() * 100);
            for (int a = 1; a < 2; a++) {
                s = s + texts.randomNames[x];
                x = (int) (Math.random() * 100);

            }

            x = (int) (Math.random() * 100); // x Wird neu generiert (0-100)
            if (x < 60)
                s = s + x; // 60%, dass der Name eine Zufällige Zahl am Ende bekommt

            return s;
        }
        return null;
    }

    public boolean checkValidName(String s){
        boolean v = false;

        if (s.length() > 2){
            v = true;
        }


        return v;
    }


    public boolean checkValidPassword(String s){
        boolean v = false;

        if (s.length() > 2){
            v = true;
        }


        return v;
    }

}
