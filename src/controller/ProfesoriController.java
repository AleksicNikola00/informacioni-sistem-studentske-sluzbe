package controller;

import java.time.LocalDate;
import model.BazaProfesora;
import view.MainFrame;

public class ProfesoriController {
	
	private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora() {
		BazaProfesora.getInstance().dodajProfesora("Pero", "Peri�", "Docent", "Doktor nauka", LocalDate.of(1990, 3, 28), "Ulica Vojvode Stepe", 
				"064-152-4141", "mikamikic@gmail.com", "Ulica cara Du�ana", "A65F21GH0");
		MainFrame.getInstance().azurirajPrikaz();
	}
}
