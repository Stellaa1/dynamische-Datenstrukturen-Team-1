package de.hebk;


import de.hebk.model.list.List;
import de.hebk.model.stack.Stack;

import java.io.*;
import java.util.Arrays;

public class SystemController extends Texts{

    String version = "";
    DataStore dataStore = new DataStore();

    static List<User> users = new List<>();
    static User local_User;

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DataStore.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            System.out.println(users.toString());
            dataStore.users = users;

            objectOutputStream.writeObject(dataStore);
            objectOutputStream.close();
        } catch (Exception e){
            System.out.println("<Bug> Save Data");
        }


    }

    public void loadData() {
        try {

            FileInputStream fileInputStream = new FileInputStream("DataStore.dat");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

            DataStore data = (DataStore) objectInputStream.readObject();

            users = data.users;
            dataStore.users = data.users;
            System.out.println(users.toString() + " users");

            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).getContext().getName());
            }

            objectInputStream.close();
            System.out.println(version);

        } catch (IOException d) {
            System.out.println("<Bug> Load Data");
        } catch (ClassNotFoundException d2) {
            System.out.println("<Bug> Load Data");
        } catch (Exception m) {
            System.out.println("<Bug> Load Data");
        }
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


    public boolean checkAnswer(Fragen f, String question, String answer){
        boolean check = false;
        System.out.println("FALSE");
        System.out.println(answer);
        for (int i = 0; i < f.getQuestions().size(); i++) {
            Question current = f.getQuestions().get(i).getContext();
            if (current.getQuestion().equals(question) && current.getOptions().get(0).getContext().equals(answer)){
                check = true;
                System.out.println("TRUE");
                break;
            }
        }
        return check;
    }


    public Stack<User> calculateTop10(){
        Stack<User> top10 = new Stack<>();
        int[] points = new int[users.size()];

        for (int i = 0; i < users.size(); i++){
            points[i] = users.get(i).getContext().getPoints();
        }

        Sorter s = new Sorter();
        s.countSort(points, points.length);

        System.out.println(Arrays.toString(points));

        for (int x : points){
            for (int i = 0; i < users.size(); i++){
                if (users.get(i).getContext().getPoints() == x){
                    top10.push(users.get(i).getContext());
                }
            }
        }

        System.out.println(top10.toString());

        return top10;
    }



}
