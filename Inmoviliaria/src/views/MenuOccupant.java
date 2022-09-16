package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOccupant {

	public static int menuManeOccupant() {
		int option = 0;
		Scanner scaner = new Scanner (System.in);
        try {
		System.out.println(" 1- Añadir Inquilino");
		System.out.println(" 2- Eliminar Inquilino");
		System.out.println(" 3- Modificar Inquilino");
		option = scaner.nextInt();
				
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¡Debe colocar un numero!");
		}		
		return option;
	
	
	}
}
