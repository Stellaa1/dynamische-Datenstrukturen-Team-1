package de.hebk;


import de.hebk.model.list.List;
import javafx.scene.control.TextField;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
public class SystemController {

    public static DataStore dataStore = new DataStore();
    private User user = new User();

    List<String> names = new List<>();

    List<String> passwords = new List<>();
    List<List<String>> achievements = new List<>();

    public void saveData() {
        try {

            FileOutputStream f = new FileOutputStream("ver.dat");
            BufferedOutputStream b = new BufferedOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(b);

            dataStore.setNames(this.names);
            dataStore.setPasswords(this.passwords);


            o.writeObject(dataStore);
            o.close();
            System.out.println(dataStore.getNames().toString() + " saved");
            System.out.println(this.names.toString());

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
            System.out.println(dataStore.getNames());

            this.names = dataStore.getNames();
            this.passwords = dataStore.getPasswords();



            obj2.close();


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


}
