package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

  public Reader() {
    
  }
  
  public void read(String filename) {
    try {
      Scanner fileScan = new Scanner(new File(filename));
      while (fileScan.hasNextLine()) {
        System.out.println("next line "+fileScan.next());
      }
      fileScan.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  public static List<String[]> readFile(String urlFichier) {
    BufferedReader lecteurAvecBuffer = null;
    List<String[]> listeDocument = new ArrayList<String[]>();
    try {
        lecteurAvecBuffer =
            new BufferedReader(
                new InputStreamReader(new FileInputStream(urlFichier), "UTF8"));
        String ligne = "";
        int nbLigne = 1;
        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            if (nbLigne > 0) {
                String[] tab = ligne.split(";");
                if (tab.length > 1) {
                    listeDocument.add(tab);
                }
            }
            nbLigne++;
        }
    } catch (IOException e) {
       System.out.println(e.getMessage());
    } finally {
        try {
            if (lecteurAvecBuffer != null) {
                lecteurAvecBuffer.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    return listeDocument;
}
  
  
}
