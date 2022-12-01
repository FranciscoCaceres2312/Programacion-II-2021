package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
	public int option;
	public int menuMane() {
		option = 0;
		Scanner scaner = new Scanner (System.in);
	    do {
	    	try {		
			    System.out.println(" Elija una opcion: ");
			    System.out.println(" 1-  Gestionar Inmuebles");
			    System.out.println(" 2-  Gestionar Inquilino");
			    System.out.println(" 3-  Generar Contrato");
			    System.out.println(" 4-  Ver contratos");
			    System.out.println(" 5-  Generar Recibo");
			    System.out.println(" 6-  Mostrar Recibos");
			    System.out.println(" 7-  Sincronizar Inmuebles");
			    System.out.println(" 8-  Sincronizar Inquilinos");
			    System.out.println(" 9-  Sincronizar Contratos");
			    System.out.println(" 10-  Terminar programa");
			    option = scaner.nextInt();	
			    if(option == 0 || option > 10) {
			    	System.out.print("\n El valor ingresado no es valido.\n"
			    			+ " Por favor vuelva a intentar.");
			    }
		    } catch (InputMismatchException e) {
		    	
			    System.out.println("Error");
			    System.out.println("Usted a colocado una letra");
			    System.out.println("¡Debe colocar un numero!");		
	        }   	
	        
	    }while(option == 0 || option > 10);
	    
	return option;
	}
	public void endProgram() {
		System.out.println(" El programa finalizó ");
	}
	
}

