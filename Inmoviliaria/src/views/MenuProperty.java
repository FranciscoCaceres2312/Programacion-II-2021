package views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Property;

public class MenuProperty {
	
	public static String keyboard() {
		
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
	}
	public void showMessages(String message) {
		System.out.println(message);
	}
	
	public int menuManeProperty() {
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
			System.out.println("!Debe colocar un numero!");
		}		
		return option;
	
	}
	
	public String[] addProperty() {
	    	
		    System.out.println(" Añada el codigo catastral del inmueble: ");
		    String numberCadastral = keyboard();
			System.out.println(" Añada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" Añada el codigo postal: ");
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
	public String[] newProperty(String[] oldProperty) {

			System.out.println(" Añada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" Añada precio del inmueble: ");
			String price = keyboard();
			String[] dataProperty = new String[5];
		    dataProperty[0] = oldProperty[0];
			dataProperty[1] = oldProperty[1];
			dataProperty[2] = direction;
			dataProperty[3] = oldProperty[3];
			dataProperty[4] = price;
			
	    return dataProperty;
	}

	public String selectDeleteProperty(ArrayList<Property> prop) {

		showsAllProperties(prop);
		String number = null;
		System.out.println("\n Ingrese el inmueble que desea eliminar: ");
		number = keyboard();
		CICLO1: 
			for(int i = 0; i < prop.size(); i++) {
				if(i+1 == Integer.parseInt(number)) {
					number = prop.get(i).getId();
					break CICLO1;
				}
			}
		return number;
	}

	public String selectmodifyProperty(ArrayList<Property> prop) {

		showsAllProperties(prop);
		String num = null;
		System.out.println("\n Ingrese el inmueble que desea Modificar: ");
		num = keyboard();
		CICLO2: 
			for(int i = 0; i < prop.size(); i++) {
				if(i+1 == Integer.parseInt(num)) {
					num = prop.get(i).getId();
					break CICLO2;
				}
			}
		return num;

	}
	
	public static void showsAllProperties(ArrayList<Property> prop) {
		for(int i  = 0; i < prop.size();i++) {
			System.out.println(i+1);
			System.out.println(prop.get(i).toString());
		}
	}
	
}
