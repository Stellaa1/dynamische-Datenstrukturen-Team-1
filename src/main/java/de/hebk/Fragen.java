package de.hebk;
import de.hebk.model.list.List;

import java.util.Arrays;

public class Fragen {

    String[] kategorien = {
      "doku/Fragen/Geschichte.csv"
    };
    int anzahl = 26;
    String kategorie;
    int difficultyValue = 20;
    int difficultyRange = 0;
    double difficultyRate = 0.1;

    int incrementValue = 0;
    int incrementRange = 0;
    double incrementRate = 0.05;


    Fragen(int a, String k){
        anzahl = a;
        kategorie = k;
    }

    public void generateQuestions(){

        if (kategorie.equals("Geschichte")){
            CSVReader csvReader = new CSVReader();
            String[] f = csvReader.read(kategorien[0],0);
            String[] d = csvReader.read(kategorien[0],1);
            String[] r = csvReader.read(kategorien[0],2);
            String[] o2 = csvReader.read(kategorien[0],3);
            String[] o3 = csvReader.read(kategorien[0],4);
            String[] o4 = csvReader.read(kategorien[0],5);

            System.out.println(Arrays.toString(f));
            String[] possible = new String[600];

            String[] o1 = new String[4];

            List<String[]> l = new List<>();
            List<Integer> l2 = new List<>();
            l.append(f);
            l.append(d);
            l.append(r);
            l.append(o2);
            l.append(o3);
            l.append(o4);
            for (int i = 1; i<f.length + 1; i++){
                d[i] = d[i].replaceAll("\\D+", "1000");
                if (Integer.parseInt(d[i]) <= difficultyValue && Integer.parseInt(d[i]) >= difficultyRange){
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
            System.out.println(l.get(0).getContext()[1]);
            System.out.println(l.get(1).getContext()[1]);
            System.out.println(l.get(0).getContext()[78] + " slj");
            System.out.println(l.get(0).getContext()[l2.size()]);
            System.out.println(l2.toString());
            System.out.println(l2.size());
            System.out.println(anzahl);
            System.out.println(l2.size()/anzahl);

            for (int i = 0; i<l2.size(); i++){
                System.out.println(l.get(0).getContext()[l2.get(i).getContext()]);
            }
        }


    }
}
