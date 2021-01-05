package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import serialization.Deserialization;

public class MyApp {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
    	MainFrame.getInstance();
    	Deserialization.ucitajListu("objekti.txt");
    }

}