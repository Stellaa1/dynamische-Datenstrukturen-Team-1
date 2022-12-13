package de.hebk;

import de.hebk.model.list.List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CSVReader {
    
    private String line = "";
    private String[] values;
    private int columns = 0;


    /**
     * Methode, um eine Liste aus allen Werten von dem Attribut mit Index 'attribut_Index' zu erstellen.
     @param path > der Pfad der CSV Datei.
     @return l > List<String[]>
     */

    public List<String[]> read(String path, int attribut_Index) {
        List<String[]> l = new List<>();
        try {
            Path p = Paths.get(path);
            if (p.toFile().isFile()) {
                BufferedReader b = new BufferedReader(new FileReader(path));
                l.toFirst();
                while ((line = b.readLine()) != null) {
                    values = line.split(",");
                    columns = line.split(",").length;
                    l.append(values);
                }


                b.close();
            }else{
                System.out.println("File does not Exist!");
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }

        return l;
    }

    public List<String> read_List_String(String path, int attribut_Index) {
        List<String> l = new List<>();
        try {
            Path p = Paths.get(path);
            if (p.toFile().isFile()) {
                BufferedReader b = new BufferedReader(new FileReader(path));
                l.toFirst();
                while ((line = b.readLine()) != null) {
                    values = line.split(",");
                    columns = line.split(",").length;
                    l.append(values[attribut_Index]);
                }


                b.close();
            }else{
                System.out.println("File does not Exist!");
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }

        return l;
    }

}