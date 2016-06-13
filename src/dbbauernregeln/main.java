/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbauernregeln;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.IOUtils;

/**
 *
 * @author Arjuna
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {

            mySQLconnection blubb = new mySQLconnection();
            blubb.readDataBase();

            
            
            File f = new File("Wetterdaten/");
            File[] files = f.listFiles();
            if (files != null) { // Erforderliche Berechtigungen etc. sind vorhanden
                for (int i = 0; i < files.length; i++) {
                    if ((!files[i].isDirectory())) {

                        blubb.insertIntoDatabase(readFile(files[i].getAbsolutePath()));
                        System.out.println(files[i].getAbsolutePath() + " beendet");

                    }
                }
            }
            // blubb.insertIntoDatabase(readFile("Wetterdaten/Cottbus_Tageswerte_20141130_20160601.txt"));
            
            
            
            blubb.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static List<Wettereintrag> readFile(String path) {
        BufferedReader bufferedReader = null;
        List<Wettereintrag> result = new ArrayList<Wettereintrag>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String s = "";
            if ((s = bufferedReader.readLine()) != null) {
                if (s.contains("STATIONS_ID; MESS_DATUM; QUALITAETS_NIVEAU; LUFTTEMPERATUR;DAMPFDRUCK;BEDECKUNGSGRAD;LUFTDRUCK_STATIONSHOEHE;REL_FEUCHTE; WINDGESCHWINDIGKEIT; LUFTTEMPERATUR_MAXIMUM;LUFTTEMPERATUR_MINIMUM;LUFTTEMP_AM_ERDB_MINIMUM; WINDSPITZE_MAXIMUM; NIEDERSCHLAGSHOEHE;NIEDERSCHLAGSHOEHE_IND;SONNENSCHEINDAUER; SCHNEEHOEHE;eor")) {
                    while ((s = bufferedReader.readLine()) != null) {

                        try {

                            StringTokenizer token = new StringTokenizer(s, "[ ;]");
                            while (token.hasMoreTokens()) {

                                result.add(new Wettereintrag(token.nextToken(), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Float.parseFloat(token.nextToken()), Integer.parseInt(token.nextToken()), Float.parseFloat(token.nextToken()), Integer.parseInt(token.nextToken()), token.nextToken()));

                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // close without throwing exception
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

}
