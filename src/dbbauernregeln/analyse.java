/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbauernregeln;

import java.util.List;

/**
 *
 * @author Arjuna
 */
public class analyse {

    public static void siebenschlaefertag(List<Wettereintrag> quelle) {
        System.out.println("Regnet es am Siebenschläfertag, der Regen sieben Wochen nicht weichen mag.\n"
                + "Ist der Siebenschläfer nass - regnet's ohne Unterlass.\n"
                + "Siebenschläfer Regen - sieben Wochen Regen.\n"
                + "Ist Siebenschläfer ein Regentag, regnet's noch sieben Wochen nach.\n"
                + "Das Wetter am Siebenschläfertag sieben Wochen so bleiben mag.");

        float gesamtniederschlag = 0;
        float niederschlagAmSiebenschlaefer = 0;
        float niederschlagSiebenWochen = 0;

        for (int i = 0; i < quelle.size(); i++) {
            gesamtniederschlag += quelle.get(i).NIEDERSCHLAGSHOEHE;

            if ((quelle.get(i).MESS_DATUM % 10000) == 627) {
                // System.out.println("datum: " + quelle.get(i).MESS_DATUM);
                niederschlagAmSiebenschlaefer = quelle.get(i).NIEDERSCHLAGSHOEHE;
            }

            if (((quelle.get(i).MESS_DATUM % 10000) > 627)
                    && ((quelle.get(i).MESS_DATUM % 10000) < 816)) {
                niederschlagSiebenWochen += quelle.get(i).NIEDERSCHLAGSHOEHE;
            }

            if ((quelle.get(i).MESS_DATUM % 10000) == 816) {
                niederschlagSiebenWochen = niederschlagSiebenWochen / 49;
                if (niederschlagAmSiebenschlaefer > (gesamtniederschlag / i)) {
                    if (niederschlagSiebenWochen > (gesamtniederschlag / i)) {
                        System.out.print("true  ");
                    } else {
                        System.out.print("false ");
                    }
                } else {
                    System.out.print("N/A   ");
                }

                System.out.println(quelle.get(i).MESS_DATUM / 10000 + " hatte am 7schlaefer Tag " + niederschlagAmSiebenschlaefer + " cm Niederschlag, in den 7 wochen danach durchschnittlich " + niederschlagSiebenWochen + " cm. Allg. Durchschnitt beträgt: " + gesamtniederschlag / i + " cm");
            }

        }
    }

}
