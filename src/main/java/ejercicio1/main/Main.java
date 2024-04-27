package ejercicio1.main;

import ejercicio1.dataBase.Persistencia;
import ejercicio1.model.SistemaRegistracion;
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
                    SistemaRegistracion sistemaRegistracion = new SistemaRegistracion(persistencia);
                    UI ui = new UI(sistemaRegistracion);
                    ui.setupUIComponents();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
