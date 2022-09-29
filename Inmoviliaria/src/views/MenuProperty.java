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
	
	
	public static int menuManeProperty() {
		int option = 0;
		
	    try {
		System.out.println(" 1- Aï¿½adir Inmueble");
		System.out.println(" 2- Eliminar Inmueble");
		System.out.println(" 3- Modificar Inmueble");
		System.out.println(" 4- Mostrar Inmuebles");
		option = Integer.parseInt(keyboard());
				
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("ï¿½Debe colocar un numero!");
		}		
		return option;
	
	}
	
	public static String[] addProperty() {
	    	
		    System.out.println(" Aï¿½ada el codigo catastral del inmueble: ");
		    String numberCadastral = keyboard();
			System.out.println(" Aï¿½ada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" Aï¿½ada el cï¿½digo postal: ");
			String postcard = keyboard();
			System.out.println(" Aï¿½ada precio del inmueble: ");
			String price = keyboard();
			String[] dataProperty = new String[4];
		
			dataProperty[0] = numberCadastral;
			dataProperty[1] = direction;
			dataProperty[2] = postcard;
			dataProperty[3] = price;
			
	    return dataProperty;
	}
	public static String[] newProperty(String[] oldProperty) {

			System.out.println(" Aï¿½ada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" Aï¿½ada precio del inmueble: ");
			String price = keyboard();
			String[] dataProperty = new String[5];
		    dataProperty[0] = oldProperty[0];
			dataProperty[1] = oldProperty[1];
			dataProperty[2] = direction;
			dataProperty[3] = oldProperty[3];
			dataProperty[4] = price;
			
	    return dataProperty;
	}
	
	public static int selectDeleteProperty(ArrayList<Property> prop) {
		
		int idDel= 0;
		MenuProperty.showsAllProperties(prop);
		try {
			System.out.println("\n     -------------------------------------------------------    ");
			System.out.println("\n Ingrese el ID del inmueble que desea eliminar: ");
			idDel = Integer.parseInt(keyboard());
		}catch(InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¿Debe colocar un numero!");
		}		
		return idDel;
	}
	
	public static boolean confirmDelete(String numberCadastralReturned) {
		
		boolean value = false;
		int val = 0;
		try {
			System.out.println(" Desea eliminar el inmueble con Nï¿½ catastral "+ numberCadastralReturned);
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
			System.out.println("¿Debe colocar un numero!");
		}		
		return value;
		
	}

	public static int selectmodifyProperty() {
		
		int idMody = 0;
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el ID del inmueble que desa modificar: ");
        idMody = Integer.parseInt(keyboard()); 
		return idMody;
		
	}
	
	public static void showsAllProperties(ArrayList<Property> prop) {
		prop.forEach(System.out::println);
		//prop.forEach((proper) -> System.out.println(proper.id+" "+ proper.cadastralNumber+" "+ proper.direction+" "+proper.postcard+" "+proper.price));
	}
	
}
