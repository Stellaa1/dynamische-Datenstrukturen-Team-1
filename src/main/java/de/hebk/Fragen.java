package de.hebk;
import de.hebk.model.list.List;
import de.hebk.model.node.Node;

import java.util.Arrays;

public class Fragen {

    private String[] kategorien = {
      "doku/Fragen/Geschichte.csv"
    };
    private int anzahl;
    String kategorie;
    private int difficultyValue = 20;
    private int difficultyRange = 0;
    private int incrementValue = 5;
    private int incrementRange = 5;
    private List<Question> questions = new List<>();


    Fragen(int a, String k){
        anzahl = a;
        kategorie = k;
    }

    public int getAnzahl(){
        return anzahl;
    }
    public List<Question> getQuestions(){
        return questions;
    }

    public void generateQuestions(){

            CSVReader csvReader = new CSVReader();
            List<String> f = csvReader.read_List_String("doku/Fragen/" + kategorie + ".csv",0);
            List<String> d = csvReader.read_List_String("doku/Fragen/" + kategorie + ".csv",1);
            List<String> r = csvReader.read_List_String("doku/Fragen/" + kategorie + ".csv",2);
            List<String> o2 = csvReader.read_List_String("doku/Fragen/" + kategorie + ".csv",3);
            List<String> o3 = csvReader.read_List_String("doku/Fragen/" + kategorie + ".csv",4);
            List<String> o4 = csvReader.read_List_String("doku/Fragen/" + kategorie + ".csv",5);

            for (int i = 1; i<f.size() + 1; i++){
                d.get(i).setContext(d.get(i).getContext().replaceAll("\\D+", "1000"));
                if (Integer.parseInt(d.get(i).getContext()) <= difficultyValue && Integer.parseInt(d.get(i).getContext()) >= difficultyRange){
                    difficultyValue+= incrementValue;
                    difficultyRange+= incrementRange;

                    Question q = new Question();
                    q.setQuestion(f.get(i).getContext().replaceAll("<K>", ","));
                    q.setDifficulty((byte) Integer.parseInt(d.get(i).getContext()));
                    q.setOptions(new List<>());
                    q.getOptions().append(r.get(i).getContext());
                    q.getOptions().append(o2.get(i).getContext());
                    q.getOptions().append(o3.get(i).getContext());
                    q.getOptions().append(o4.get(i).getContext());
                    questions.append(q);

                    if (difficultyRange > 60){
                        difficultyRange = 60;
                    }

                    if (difficultyRange >= difficultyValue){
                        difficultyRange = difficultyValue--;
                    }

                    if (questions.size() >= anzahl){
                        break;
                    }
                }
            }

            for (int i = 0; i < questions.size(); i++){
                //System.out.println(questions.get(i).getContext().getQuestion() + "\n" + questions.get(i).getContext().getOptions().toString());
                System.out.println(questions.get(i).getContext().getOptions().toString());
            }
        }

}