package de.hebk;


import de.hebk.model.list.List;
import de.hebk.model.stack.Stack;

import java.io.*;

public class SystemController extends Texts{

    private DataStore dataStore = new DataStore();

    public static List<User> users = new List<>();
    public static User local_User;

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

        } catch (Exception d) {
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
        int x = (int)Math.floor(Math.random() * (texts.firstNames.length));
        String s = "";
        int y = (int)Math.floor(Math.random() * (texts.lastNames.length));

        s = texts.firstNames[x] + " " + texts.lastNames[y];
        return s;
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


    public Stack<User> calculateTopPlayers(String type){
        Stack<User> top10 = new Stack<>();
        int[] points = new int[users.size()];
        if (type.equals("Normal")){
            for (int i = 0; i < users.size(); i++){
                points[i] = users.get(i).getContext().getPoints();
            }
            Sorter s = new Sorter();
            s.countSort(points, points.length);
            for (int i = 0; i < points.length; i++){
                for (int x = 0; x < users.size(); x++){
                    User u = users.get(x).getContext();
                    if (u.getPoints() == points[i] && !top10.find(u)){
                        top10.push(u);
                        break;
                    }
                }
            }
        }

        if (type.equals("Reverse")){
            for (int i = 0; i < users.size(); i++){
                points[i] = users.get(i).getContext().getReversePoints();
            }
            Sorter s = new Sorter();
            s.countSort(points, points.length);
            for (int i = 0; i < points.length; i++){
                for (int x = 0; x < users.size(); x++){
                    User u = users.get(x).getContext();
                    if (u.getReversePoints() == points[i] && !top10.find(u)){
                        top10.push(u);
                        break;
                    }
                }
            }
        }
        return top10;
    }
}