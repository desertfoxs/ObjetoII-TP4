package ejercicio1.main;

import ejercicio1.dataBase.Persistencia;
import ejercicio1.model.Model;
import ejercicio1.ui.UI;


public class Main {

    public static void main(String[] args) {
        launchApplication();
    }

    private static void launchApplication() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    //Agregando un nuevo participante
                    Persistencia persistencia = new Persistencia();
                    Model model = new Model(persistencia);
                    UI ui = new UI(model);
                    ui.setupUIComponents();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
