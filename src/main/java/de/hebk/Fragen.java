package de.hebk;
import de.hebk.model.list.List;

import java.util.Arrays;

public class Fragen {

    private String[] kategorien = {
      "doku/Fragen/Geschichte.csv"
    };
    private int anzahl = 26;
    String kategorie;
    private int difficultyValue = 20;
    private int difficultyRange = 0;
    private double difficultyRate = 0.1;

    private int incrementValue = 0;
    private int incrementRange = 0;
    private double incrementRate = 0.05;


    Fragen(int a, String k){
        anzahl = a;
        kategorie = k;
    }

    public void generateQuestions(){

        if (kategorie.equals("Geschichte")){
            CSVReader csvReader = new CSVReader();
            List<String> f = csvReader.read_List_String(kategorien[0],0);
            List<String> d = csvReader.read_List_String(kategorien[0],1);
            List<String> r = csvReader.read_List_String(kategorien[0],2);
            List<String> o2 = csvReader.read_List_String(kategorien[0],3);
            List<String> o3 = csvReader.read_List_String(kategorien[0],4);
            List<String> o4 = csvReader.read_List_String(kategorien[0],5);

            System.out.println(f.toString());
            String[] possible = new String[600];

            String[] o1 = new String[4];

            List<String[]> f2 = csvReader.read(kategorien[0],0);

            System.out.println(f2.toString() + " f2");
            System.out.println(f2.get(1).getContext()[2]);
            f2.toFirst();
            f2.remove();
            System.out.println(Arrays.toString(f2.get(0).getContext()));

            List<List<String>> l = new List<>();
            List<Integer> l2 = new List<>();
            l.append(f);
            l.append(d);
            l.append(r);
            l.append(o2);
            l.append(o3);
            l.append(o4);

            for (int i = 1; i<f.size() + 1; i++){
                System.out.println(d.get(i).getContext());
                d.get(i).setContext(d.get(i).getContext().replaceAll("\\D+", "1000"));
                if (Integer.parseInt(d.get(i).getContext()) <= difficultyValue && Integer.parseInt(d.get(i).getContext()) >= difficultyRange){
                    l2.append(i);
                    difficultyValue+= incrementValue;
                    difficultyRange+= incrementRange;
                    difficultyRate+= incrementRate;
                    //difficultyValue+= difficultyValue*(difficultyRate);
                    if (difficultyRange > 60){
                        difficultyRange = 60;
                    }

                    if (difficultyRange >= difficultyValue){
                        difficultyRange = difficultyValue--;
                    }

                    if (l2.size() >= anzahl){
                        break;
                    }
                }
            }
            System.out.println(l.size());
            System.out.println(l2.toString());
            System.out.println(l2.size());
            System.out.println(anzahl);
            System.out.println(l2.size()/anzahl);

        }
    }
}
