package elmsort;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhunter3
 */
public class FileReader {
    
    public static void main(String[] args){
        ArrayList el = readCSV("Elements.csv");
        
        
    }
    
     public static ArrayList readCSV(String fileName) {
        Path path = Paths.get(fileName);
        BufferedReader br = null;
        String line = "";
        String[] el = null;
        ArrayList<ElementNode> Final = new ArrayList<ElementNode>();
        int count = 0;

        try {

            br = new BufferedReader(new java.io.FileReader(path.toFile()));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                
                el = line.split(",");
                ElementNode node = new ElementNode(el[0],el[1],Integer.parseInt(el[2]),Double.parseDouble(el[3]));
                //System.out.println("Elemnts [code= " + el[1]+ " , weight=" + el[3] + "]"+count);
                Final.add(node);
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.println("Done");
        return Final;
    }
    
}
