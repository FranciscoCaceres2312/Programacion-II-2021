package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
	public static int menuMane() {
		int option = 0;
		Scanner scaner = new Scanner (System.in);
	    do {
	    	try {
	    		
		    System.out.println(" Elija una opcion: ");
		    System.out.println(" 1-  Gestionar Inmuebles");
		    System.out.println(" 2-  Gestionar Inquilino");
		    System.out.println(" 3-  Terminar programa");
		    option = scaner.nextInt();	
		    } catch (InputMismatchException e) {
		    	
			    System.out.println("Error");
			    System.out.println("Usted a colocado una letra");
			    System.out.println("¡Debe colocar un numero!");		
	        }
	    }while(option != 1 && option != 2 && option != 3);
	    
	return option;
	}
	
}

