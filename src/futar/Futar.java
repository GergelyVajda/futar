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
        String[] adatok = new String[1000];
        try {
            FileReader buta = new FileReader(txt);
            BufferedReader okos = new BufferedReader(buta);
            String ideiglenes = " ";
            for (int i = 0; i < 1000; i++) {
                ideiglenes = okos.readLine();
                if (ideiglenes == null) {
                    break;
                }
                adatok[i] = ideiglenes;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("file?");
        } catch (IOException ex) {
            System.out.println("beolvasás?");
        }
        return adatok;
    }

    public static int elemSzam(String[] adatok) {
        int hossz = 0;
        for (int i = 0; i < 1000; i++) {
            if (adatok[i] == null) {
                break;
            }
            hossz++;
        }
        return hossz;
    }

    public static void main(String[] args) {
        String txt = "tavok.txt";
        String[] ideiglenes = beolvas(txt);
        int hossz = elemSzam(ideiglenes);
        //feldarabolás
        String[] darabolt = new String[3];
        Integer[][] adatok = new Integer[3][hossz];
        for (int i = 0; i < hossz; i++) {
            darabolt = ideiglenes[i].split(" ");
            adatok[0][i] = Integer.parseInt(darabolt[0]);
            adatok[1][i] = Integer.parseInt(darabolt[1]);
            adatok[2][i] = Integer.parseInt(darabolt[2]);
            //System.out.println(adatok[0][i]+" "+adatok[1][i]+" "+adatok[2][i]);
        }
        //2
        int legk = 8;
        int sorsz = 41;
        int tav = 0;
        for (int i = 0; i < hossz; i++) {
            if (adatok[0][i] <= legk) {
                legk = adatok[0][i];
                if (adatok[1][i] < sorsz) {
                    sorsz = adatok[1][i];
                    tav = adatok[2][i];
                }
            }
        }
        System.out.println("2. feladat");
        System.out.println("A hét legelső útja " + tav + " km hosszú volt.");
        //3
        int legn = 0;
        sorsz = 0;
        tav = 0;
        for (int i = 0; i < hossz; i++) {
            if (adatok[0][i] >= legn) {
                legn = adatok[0][i];

            }
        }
        for (int i = 0; i < hossz; i++) {
            if (adatok[0][i].equals(legn)) {
                if (adatok[1][i] > sorsz) {
                    sorsz = adatok[1][i];
                    tav = adatok[2][i];
                }
            }
        }

        System.out.println("3. feladat");
        System.out.println("A hét utolsó útja " + tav + " km hosszú volt.");
        //4
        Integer[] szNap=new Integer[7];
        for (int i = 0; i < hossz; i++) {
            szNap[adatok[0][i]-1]++;
        }
        int szabad=0;
        for (int i = 0; i < 7; i++) {
            if (szNap[i]==null) {
                szabad=i+1;
            }
        }
        System.out.println("4. feladat");
        System.out.println("A futár a hét"+szabad+". napján tartott szabadnapot.");
        //5
        

    }

}
