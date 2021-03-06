package Fach_2_Objektorientierung.A90_Interfaces_Delegate_Pattern;

/**
 * http://www.programmierenlernenhq.de/einfuehrung-in-java-design-patterns-software-entwurfsmuster/
 * -----------------------------------------------------------------------------
 * Die ganze Loesung wird so erweiterbar. Neue Printer muessen einfach nur das
 * Printable Interface implementieren!
 * Es muss weder Printer noch Printable angepasst werden
 * -----------------------------------------------------------------------------
 */
public class ColorPrinter implements Printable // Delegate
{
    public void print()
    {
        System.out.println("ColorPrinter prints!");
    }
}