package ejercicio3.main;
import ejercicio3.UI.RadioCompetition;
import ejercicio3.dataBase.GrabarLeerBD;
import ejercicio3.dataBase.GrabarYLeerTXT;
import ejercicio3.model.IncribirConcurso;

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

                    IncribirConcurso incribirConcurso = new IncribirConcurso(grabarYLeerTXT);
                    RadioCompetition radioCompetition = new RadioCompetition(incribirConcurso);

                } catch (Exception e) {
                    // log exception...
                    System.out.println(e);
                }
            }
        });
    }
}

