/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbauernregeln;


/**
 *
 * @author Arjuna
 */
public class Wettereintrag {
    
    String STATION; 
    int MESS_DATUM; 
    int QUALITAETS_NIVEAU; 
    float LUFTTEMPERATUR;
    float DAMPFDRUCK;
    float BEDECKUNGSGRAD;
    float LUFTDRUCK_STATIONSHOEHE;
    float REL_FEUCHTE; 
    float WINDGESCHWINDIGKEIT; 
    float LUFTTEMPERATUR_MAXIMUM;
    float LUFTTEMPERATUR_MINIMUM;
    float LUFTTEMP_AM_ERDB_MINIMUM; 
    float WINDSPITZE_MAXIMUM; 
    float NIEDERSCHLAGSHOEHE;
    int NIEDERSCHLAGSHOEHE_IND;
    float SONNENSCHEINDAUER; 
    int SCHNEEHOEHE;
    String eor;  

    public Wettereintrag(String STATION, int MESS_DATUM, int QUALITAETS_NIVEAU, float LUFTTEMPERATUR, float DAMPFDRUCK, float BEDECKUNGSGRAD, float LUFTDRUCK_STATIONSHOEHE, float REL_FEUCHTE, float WINDGESCHWINDIGKEIT, float LUFTTEMPERATUR_MAXIMUM, float LUFTTEMPERATUR_MINIMUM, float LUFTTEMP_AM_ERDB_MINIMUM, float WINDSPITZE_MAXIMUM, float NIEDERSCHLAGSHOEHE, int NIEDERSCHLAGSHOEHE_IND, float SONNENSCHEINDAUER, int SCHNEEHOEHE, String eor) {
        this.STATION = STATION;
        this.MESS_DATUM = MESS_DATUM;
        this.QUALITAETS_NIVEAU = QUALITAETS_NIVEAU;
        this.LUFTTEMPERATUR = LUFTTEMPERATUR;
        this.DAMPFDRUCK = DAMPFDRUCK;
        this.BEDECKUNGSGRAD = BEDECKUNGSGRAD;
        this.LUFTDRUCK_STATIONSHOEHE = LUFTDRUCK_STATIONSHOEHE;
        this.REL_FEUCHTE = REL_FEUCHTE;
        this.WINDGESCHWINDIGKEIT = WINDGESCHWINDIGKEIT;
        this.LUFTTEMPERATUR_MAXIMUM = LUFTTEMPERATUR_MAXIMUM;
        this.LUFTTEMPERATUR_MINIMUM = LUFTTEMPERATUR_MINIMUM;
        this.LUFTTEMP_AM_ERDB_MINIMUM = LUFTTEMP_AM_ERDB_MINIMUM;
        this.WINDSPITZE_MAXIMUM = WINDSPITZE_MAXIMUM;
        this.NIEDERSCHLAGSHOEHE = NIEDERSCHLAGSHOEHE;
        this.NIEDERSCHLAGSHOEHE_IND = NIEDERSCHLAGSHOEHE_IND;
        this.SONNENSCHEINDAUER = SONNENSCHEINDAUER;
        this.SCHNEEHOEHE = SCHNEEHOEHE;
        this.eor = eor;
    }
    
    
    
}
