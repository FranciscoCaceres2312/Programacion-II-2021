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
	public String selectDeleteOccupant(ArrayList<Occupant> occu) {
		
		String idDel = "";
		showsAllOccupants(occu);
		try {
			System.out.println("\n     -------------------------------------------------------    ");
			System.out.println("\n Ingrese el Occupante que desea eliminar del sistema: ");
			idDel = keyboard();
			CICLO1: 
			for(int i = 0; i < occu.size(); i++) {
				if(i+1 == Integer.parseInt(idDel)) {
				    idDel = occu.get(i).getId();
				    break CICLO1;
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¿Debe colocar un numero!");
		}		
		return idDel;
	}
	public static void showsAllOccupants(ArrayList<Occupant> occ) {
    for(int i = 0; i < occ.size(); i++) {
    	System.out.println(i+1);
    	System.out.println(occ.get(i).toString());
    }
		
	}
	public String selectmodifyOccupant(ArrayList<Occupant> occu) {
		
		showsAllOccupants(occu);
		String idMody;
		System.out.println("\n     -------------------------------------------------------    ");
		System.out.println("\n Ingrese el ID del inquilino que desea modificar: ");
        idMody = keyboard(); 
        CICLO2: 
			for(int i = 0; i < occu.size(); i++) {
				if(i+1 == Integer.parseInt(idMody)) {
				    idMody = occu.get(i).getId();
				    break CICLO2;
				}
			}
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
