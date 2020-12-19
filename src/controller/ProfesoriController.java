package controller;

import javax.swing.JFrame;

import view.MainFrame;
import view.ProfesoriDodajDialog;

public class ProfesoriController {
	
	private static JFrame parent;
	private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora() {
		ProfesoriDodajDialog dialog = new ProfesoriDodajDialog(parent, "Dodavanje profesora", true);
		dialog.setVisible(true);
		MainFrame.getInstance().azurirajPrikaz();
	}
}
