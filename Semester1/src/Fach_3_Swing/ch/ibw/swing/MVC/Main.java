package Fach_3_Swing.ch.ibw.swing.MVC;

/**
 * Created by user on 26.12.2016.
 */
import javax.swing.SwingUtilities;

public class Main
{
    // TESTKLASSE

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model(0);
                View view = new View("-");
                Controller controller = new Controller(model,view);
                controller.control();
            }
        });
    }
}
