/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gergely.vajda
 */
public class Futar {

    
   public static String[] beolvas(String txt) {
       String[] adatok=new String[1000];
       try {
           FileReader buta=new FileReader(txt);
           BufferedReader okos=new BufferedReader(buta);
           String ideiglenes=" ";
           for (int i = 0; i < 1000; i++) {
               ideiglenes=okos.readLine();
               if (ideiglenes==null) {
                   break;
               }
               adatok[i]=ideiglenes;
           }
           
       } catch (FileNotFoundException ex) {
           System.out.println("file?");
       } catch (IOException ex) {
           System.out.println("beolvasás?");
       } 
       return adatok;
    }
  public static int elemSzam(String[] adatok){
      int hossz=0;
  for (int i = 0; i < 1000; i++) {
            if (adatok[i]==null) {
                break;
            }
            hossz++;
        }
  return hossz;
  }
   
    public static void main(String[] args) {
        String txt="tavok.txt";
        String[] adatok=beolvas(txt);
        int hossz=elemSzam(adatok);
        
    }
    
}
