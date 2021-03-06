package Fach_2_Objektorientierung.A90_Vererbung;

/**
 * Created by rk on 04.10.16.
 */

public class Euro extends Waehrung {

    /** Ein Euro ist soviel Dollar wert */
    private static double kurs=1;

    /** Instanzvariable: Wert in Euro */
    private double wert;

    /** Konstruktor */
    public Euro(double wert) {
        this.wert = wert;
    }

    /** Deklaration der sonst abstrakten Methode dollarBetrag */
    public double dollarBetrag() {
        return wert*kurs;
    }

    /** Gibt den Wert der Waehrung in Euro zurueck */
    public double euroBetrag() {
        return wert;
    }

    /** Zugriff auf die private Klassenvariable */
    public static void setEuroKurs(double Kurs) {
        kurs=Kurs;
    }


    // Aufgabe 9.3
    @Override
    public String toString(){
        return "Wert in Euro: " +euroBetrag();
    }

}