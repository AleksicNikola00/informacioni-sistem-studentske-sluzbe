package view;

import controller.ProfesoriController;
import model.BazaProfesora;

public class MyApp {

    public static void main(String[] args) {
    	BazaProfesora.getInstance();
    	ProfesoriController.getInstance();
    	MainFrame.getInstance();
    }

}