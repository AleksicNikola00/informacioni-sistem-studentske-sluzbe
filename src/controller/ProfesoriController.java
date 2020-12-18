package controller;

import java.time.LocalDate;

import javax.swing.JFrame;

import model.BazaProfesora;
import view.MainFrame;

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
		BazaProfesora.getInstance().dodajProfesora("Pero", "Periæ", "Docent", "Doktor nauka", LocalDate.of(1990, 3, 28), "Ulica Vojvode Stepe", 
				"064-152-4141", "mikamikic@gmail.com", "Ulica cara Dušana", "A65F21GH0");
		MainFrame.getInstance().azurirajPrikaz();
	}
}
