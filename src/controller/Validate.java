package controller;

import java.util.List;

import model.BazaStudenta;
import model.Student;

public class Validate {
	
	public static boolean validateUniqueIndex(String brIndexa) {
		boolean valid=true;
		List<Student> studenti= BazaStudenta.getInstance().getStudenti();
		for (Student student : studenti) {
			if(student.getBrojIndexa().equals(brIndexa)) {
				valid=false;
				break;
			}
		}
		
		return valid;
	}
	
	public static boolean validateESPB(String s,int length) {
		boolean valid=true;
		if(length==0)
			valid=false;
		try {
			int brojESPB=Integer.parseInt(s);
			if(brojESPB<1 || brojESPB>60)
				valid=false;
		}
		catch(NumberFormatException e) {
			valid=false;
		}
		
		
		return valid;
	}
	
	public static boolean validateYear(String s,int length) {
		boolean valid=true;
		if (length == 0) {
			valid=false;
		}
		
		try {
			int brojGodina=Integer.parseInt(s);
			if(brojGodina<1900 || brojGodina>2021)
				valid=false;
		}
		catch(NumberFormatException e) {
			valid=false;
		}
		return valid;
	}
	
	public static boolean validateString(String s,int length) {
		boolean valid=true;
		if (length == 0) {
			valid=false;
		}
		else if (Character.isUpperCase(s.charAt(0)) == false) {
			valid=false;
		}
		for (int i = 1; i < length; i++) {
	        if (Character.isLowerCase(s.charAt(i)) == false) 
	        	valid=false;
	        
	    }
		return valid;
	}
	
	public static boolean validatePhoneNumber(String s,int length) {
		boolean valid=true;
		if (length < 9 || length > 13) {
			valid=false;
		}
		for (int i = 0; i < length; i++) {
	        if (Character.isDigit(s.charAt(i)) == false) {
	        	valid=false;
	        }
	    }
		return valid;
	}
	
	public static boolean validateIDCardNumber(String s,int length) {
		boolean valid=true;
		if (length < 6 || length > 13) {
			valid = false;
		}
		
		for (int i = 0; i < length; i++) {
	        if (!(Character.isDigit(s.charAt(i)) == true || Character.isUpperCase(s.charAt(i)) == true)) {
	        	valid = false;
	        }
	    }
		return valid;
	}
}
