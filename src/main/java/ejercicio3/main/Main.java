package ejercicio3.main;
import ejercicio3.UI.RadioCompetition;
import ejercicio3.dataBase.GrabarLeerBD;
import ejercicio3.dataBase.GrabarYLeerTXT;
import ejercicio3.model.Model;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) { launchApplication();}

    private static void launchApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GrabarYLeerTXT grabarYLeerTXT = new GrabarYLeerTXT("C:/Users/desertfoxs/Desktop/txt tp4 ejercicio 3/");
                    var BD = new GrabarLeerBD();

                    Model model = new Model(BD);
                    RadioCompetition radioCompetition = new RadioCompetition(model);

                } catch (Exception e) {
                    // log exception...
                    System.out.println(e);
                }
            }
        });
    }
}

