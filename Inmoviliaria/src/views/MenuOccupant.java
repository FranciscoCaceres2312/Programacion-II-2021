package views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Occupant;

public class MenuOccupant {

	public static String keyboard() {
		
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
		
	}
	public static int menuManeOccupant() {
		int option = 0;
		Scanner scaner = new Scanner (System.in);
        try {
		System.out.println(" 1- Añadir Inquilino");
		System.out.println(" 2- Eliminar Inquilino");
		System.out.println(" 3- Modificar Inquilino");
		System.out.println(" 4- Mostrar Inquilino");
		option = Integer.parseInt(keyboard());
				
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¡Debe colocar un numero!");
		}		
		return option;
	}
	
	public static String[] addOccupant() {
    	
	    System.out.println(" Ingrese el DNI: ");
	    String numberCadastral = keyboard();
		System.out.println(" Ingrese el Nombre:");
		String direction = keyboard();
		System.out.println(" Ingrese la edad: ");
		String postcard = keyboard();
		String[] dataOccupant = new String[3];
		dataOccupant[0] = numberCadastral;
		dataOccupant[1] = direction;
		dataOccupant[2] = postcard;
		
    return dataOccupant;
    }
	public static void showsOccupants(ArrayList<Occupant> occu) {
		occu.forEach(System.out::println);
	}
	public static int selectOccupantModify(ArrayList<Occupant> occu) {
		int result = 0;
		occu.forEach(System.out::println);
		try {
			System.out.println("\n Ingrese el DNI de la persona que desea modificar: ");
			result = Integer.parseInt(keyboard());
		}catch(InputMismatchException e) {
			System.out.println(" Debe ingresar un dato numerico \n");
		}
		return result;
	}
	
	public static int selectOccupantDelete(ArrayList<Occupant> occu) {
		int result = 0;
		occu.forEach(System.out::println);
		try {
			System.out.println(" Ingrese el DNI de la persona que desea eliminar del Sistema: ");
			result = Integer.parseInt(keyboard());
		}catch(InputMismatchException e) {
			System.out.println(" Debe ingresar un dato numerico \n");
		}
		return result;
	}
	public static boolean confirmDelete(int dni) {
		
		boolean value = false;
		int val = 0;
		try {
			System.out.println(" ¿Desea eliminar al inquilino con el DNI "+ dni+" ?");
			System.out.println(" 1- SI "+ "\n 2- NO");
			val = Integer.parseInt(keyboard());
			if(val == 1) {
				value = true;
			}
			if(val == 2) {
				value = false;
			}
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¡Debe colocar un numero!");
		}		
		return value;
	}
}
