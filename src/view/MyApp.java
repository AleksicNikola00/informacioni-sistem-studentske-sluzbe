package view;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.BazaStudenta;
import serialization.Deserialization;

public class MyApp {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
    	Deserialization.ucitajStudente(BazaStudenta.getInstance().getStudenti(), "datoteka.txt");
    	MainFrame.getInstance();
    }

}