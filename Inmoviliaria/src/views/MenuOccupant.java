package views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Occupant;
import model.Property;

public class MenuOccupant {
	
    public static String keyboard() {
    	Scanner scaner = new Scanner (System.in);
	    String var = scaner.nextLine(); 
	    return var; 
	}
 
	public int menuManeOccupant() {
		int num = 0;
        try {
		System.out.println(" 1- Añadir Inquilino");
		System.out.println(" 2- Eliminar Inquilino");
		System.out.println(" 3- Modificar Inquilino");
		System.out.println(" 4- Mostrar Inquilinos");
		num = Integer.parseInt(keyboard());
				
		} catch (InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¡Debe colocar un numero!");
		}		
		return num;
	}	
	public String[] addOccupant() {
	    	
		    System.out.println(" Ingrese el DNI: ");
		    String dni = keyboard();
			System.out.println(" Ingrese el Nombre:");
			String name = keyboard();
			System.out.println(" Ingrese la edad: ");
			String age = keyboard();
			String[] dataOccupant = new String[3];
			dataOccupant[0] = dni;
			dataOccupant[1] = name;
			dataOccupant[2] = age;
			
	    return dataOccupant;
	    }
	public int selectDeleteOccupant(ArrayList<Occupant> occu) {
		
		int idDel= 0;
		showsAllOccupants(occu);
		try {
			System.out.println("\n     -------------------------------------------------------    ");
			System.out.println("\n Ingrese el id del Occupante que desea eliminar del sistema: ");
			idDel = Integer.parseInt(keyboard());
		}catch(InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¿Debe colocar un numero!");
		}		
		return idDel;
	}
	public static void showsAllOccupants(ArrayList<Occupant> occ) {
    occ.forEach(System.out::println);
		
	}
	public int selectmodifyOccupant(ArrayList<Occupant> occu) {
		
		showsAllOccupants(occu);
		int idMody = 0;
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el ID del inquilino que desea modificar: ");
        idMody = Integer.parseInt(keyboard()); 
		return idMody;
		
	}
	public String[] newOccupant(String[] oldOccupant) {

		System.out.println(" Añada el DNI: ");
		String dni = keyboard();
		System.out.println(" Añada el nombre: ");
		String nombre = keyboard();
		System.out.println(" Añada la edad: ");
		String age = keyboard();
		String[] dataProperty = new String[4];
	    dataProperty[0] = oldOccupant[0];
		dataProperty[1] = dni;
		dataProperty[2] = nombre;
		dataProperty[3] = age;
		
    return dataProperty;
}
	
}
