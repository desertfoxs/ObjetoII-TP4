package main;

import dataBase.Persistencia;
import model.Model;
import ui.UI;

import java.awt.*;


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
