package de.hebk.model.queue;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVReader {
    
    String line = "";
    String[] values;
    String[] endValues;
    List<String[]> endArray = new ArrayList<>();
    ArrayList<String> stringValues = new ArrayList<>();
    int colums = 0;


    /**
     * Methode, um ein Array aus allen Werten von dem Attribut mit Index 'attribut_Index' zu erstellen.
     @param path > der Pfad der CSV Datei.
     @param attribut_Index > Index von dem gewählten Array. Dieser ist der ausgegeben Wert aus der Methode getcolumn() in Menu.
     @return endvalues > String[]
     */

    public String[] read(String path, int attribut_Index) {

        try {
            Path p = Paths.get(path);
            if (p.toFile().isFile()) {
                BufferedReader b = new BufferedReader(new FileReader(path));


                while ((line = b.readLine()) != null) {
                    values = line.split(",");
                    colums = line.split(",").length;
                    stringValues.add(Arrays.toString(values));
                    endArray.add(values);
                }

                endValues = new String[stringValues.size() - 1];

                for (int i = 1; i < stringValues.size(); i++) {
                    endValues[i - 1] = endArray.get(i)[attribut_Index].toString();
                }

                b.close();
            }else{
                System.out.println("File does not Exist!");
                endValues = null;
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }

        return endValues;
    }


    /**
     * Methode, um eine Datei aus dem Array 'v' zu schreiben.
     @param path > der Pfad, wo die CSV Datei geschrieben wird.
     @param v > sortiertes Array
     */

    /**
     * Methode, um eine Datei aus dem Array 'v' zu schreiben.
     @param path > der Pfad, wo die CSV Datei geschrieben wird.
     @param v > sortiertes Array mit allen Werten aus dem gewählten Attribut
     */

    public void write(String relativePath, Comparable[] v){
        try {

            File file = new File(relativePath);
            PrintWriter writer = new PrintWriter(file);

            String attributes = stringValues.get(0);
            attributes = attributes.replace("[", "");
            attributes = attributes.replace("]", "");
            attributes = attributes.replace(" ", "");

            writer.println(attributes);

            ArrayList<String[]> wv = new ArrayList<>();
             
            for (int i = 0; i < v.length; i++){
                for (String[] s : endArray){
                    for (int x = 0; x < s.length; x++){
                        if (s[x].toString().equals(v[i]) && !wv.contains(s)){
                            String stowrite = Arrays.toString(s);
                            stowrite = stowrite.replace("[", "");
                            stowrite = stowrite.replace("]", "");
                            stowrite = stowrite.replace(" ", "");
                            writer.println(stowrite);
                            wv.add(s);
                            break;
                        }
                    }
                }
            }
            
            
            writer.close();

        } catch (Exception e) {
        }
    }

    /**
     * Methode, um alle Attribute einer Datei auszugeben.
     @return endArray.get(0) > Alle Attribute der Datei
     */

    public String[] getAttributes(){
        return endArray.get(0);
    }
    
}