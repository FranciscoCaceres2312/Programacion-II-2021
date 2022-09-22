package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Property;

public class MenuProperty {
	/* El metodo keyboard crea un objeto Scanner que ser� utilizado en esta clase.
	 * */
	public static String keyboard() {
		
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
	}
	
	/* El metodo menuManeProperty es el primer menu que se muestra al ususario despues de
	 * haber seleccionado que desea gestionar un inmueble. 
	 * Retorna la opci�n que elige el usuario de tipo int.
	 * */
	public static int menuManeProperty() {
		int option = 0;
		
	    try {
		System.out.println(" 1- A�adir Inmueble");
		System.out.println(" 2- Eliminar Inmueble");
		System.out.println(" 3- Modificar Inmueble");
		System.out.println(" 4- Mostrar Inmuebles");
		option = Integer.parseInt(keyboard());
				
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("�Debe colocar un numero!");
		}		
		return option;
	
	}
	/* El metodo addProperty pide al usuario que ingrese los datos necesarios para a�adir un inmueble al sistema. 
	 * Retorna los valores ingresados en un arreglo de tipo String.
	 * */
	public static String[] addProperty() {
	    	
		    System.out.println(" A�ada el codigo catastral del inmueble: ");
		    String numberCadastral = keyboard();
			System.out.println(" A�ada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" A�ada el c�digo postal: ");
			String postcard = keyboard();
			System.out.println(" A�ada precio del inmueble: ");
			String price = keyboard();
			String[] dataProperty = new String[4];
		
			dataProperty[0] = numberCadastral;
			dataProperty[1] = direction;
			dataProperty[2] = postcard;
			dataProperty[3] = price;
			
	    return dataProperty;
	}
	public static String[] newProperty(String[] oldProperty) {

			System.out.println(" A�ada la direccion del inmueble: ");
			String direction = keyboard();
			System.out.println(" A�ada precio del inmueble: ");
			String price = keyboard();
			String[] dataProperty = new String[5];
		    dataProperty[0] = oldProperty[0];
			dataProperty[1] = oldProperty[1];
			dataProperty[2] = direction;
			dataProperty[3] = oldProperty[3];
			dataProperty[4] = price;
			
	    return dataProperty;
	}
	/* El metodo selectDeleteProperty solicita al usuario que ingrese el codigo del inmueble que se desea eliminar.
	 * Retorna un String con el codigo ingresado por el usuario.
	 * */
	public static int selectDeleteProperty() {
		
		int idDel= 0;
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el ID del inmueble que desa eliminar: ");
		idDel = Integer.parseInt(keyboard());
		return idDel;
	}
	/* El metodo confirmDelte le pide al usuario que confirme la eliminacion de un inmueble.
	 * Retorna un valor Boolean con la confirmaci�nn del inmueble. 
	 * */
	public static boolean confirmDelete(String numberCadastralReturned) {
		
		boolean value = false;
		int val = 0;
		try {
			System.out.println(" Desea eliminar el inmueble con N� catastral "+ numberCadastralReturned);
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
			System.out.println("�Debe colocar un numero!");
		}		
		return value;
		
	}
	/* El metodo selectmodifyProperty solicita al usuario que ingrese el codigo del inmueble que se desea modificar.
	 * Retorna un String con el codigo ingresado por el usuario.
	 * */
	public static int selectmodifyProperty() {
		
		int idMody = 0;
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el ID del inmueble que desa modificar: ");
        idMody = Integer.parseInt(keyboard()); 
		return idMody;
		
	}
	
}
