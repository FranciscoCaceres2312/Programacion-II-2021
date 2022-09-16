package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuProperty {
	
	public static String keyboard() {
		
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
		
	}
	
	public static int menuManeProperty() {
		int option = 0;
		
	    try {
		System.out.println(" 1- Añadir Inmueble");
		System.out.println(" 2- Eliminar Inmueble");
		System.out.println(" 3- Modificar Inmueble");
		System.out.println(" 4- Mostrar Inmuebles");
		option = Integer.parseInt(keyboard());
				
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¡Debe colocar un numero!");
		}		
		return option;
	
	}
	
	public static String[] addProperty() {
	    	
		    System.out.println(" Añada el codigo catastral del inmueble: ");
		    String numberCadastral = keyboard();
			System.out.println(" Añada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" Añada el código postal: ");
			String postcard = keyboard();
			System.out.println(" Añada precio del inmueble: ");
			String price = keyboard();
			String[] dataProperty = new String[4];
			dataProperty[0] = numberCadastral;
			dataProperty[1] = direction;
			dataProperty[2] = postcard;
			dataProperty[3] = price;
			
	    return dataProperty;
	}
	
	public static String selectDeleteProperty() {
		
		String numberCadastral = "";
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el codigo catastral del inmueble que desa eliminar: ");
		numberCadastral = keyboard();
		return numberCadastral;
	}
	
	public static boolean confirmDelete(String numberCadastralReturned) {
		
		boolean value = false;
		int val = 0;
		try {
			System.out.println(" Desea eliminar el inmueble con N° catastral "+ numberCadastralReturned);
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
	
	public static String selectmodifyProperty() {
		
		String numberCadastral1 = "";
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el codigo catastral del inmueble que desa modificar: ");
        numberCadastral1 = keyboard(); 
		return numberCadastral1;
		
	}
	
}
