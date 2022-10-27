package views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Contract;
import model.Occupant;
import model.Property;

public class MenuContract {
	//public MenuOccupant menuOccupant;
	//public MenuProperty menuProperty;
	public static String keyboard() {
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
	}

	public int[] AddContract(ArrayList<Occupant> ocu, ArrayList<Property> prop) {
		int[] result = new int[6];
		try {
			System.out.println("Ingrese el año de inicio de contrato:");
			result[0] = Integer.parseInt(keyboard());
			System.out.println("Ingrese el mes de inicio de contrato:");
			result[1] = Integer.parseInt(keyboard());
			System.out.println("Ingrese el dia de inicio de contrato:");
			result[2] = Integer.parseInt(keyboard());
			System.out.println("Ingrese los meses de contrato");
			result[3] = Integer.parseInt(keyboard());
			MenuOccupant.showsAllOccupants(ocu);
			//this.menuOccupant.showsAllOccupants(ocu);
			System.out.println("Ingrese el ID del inquilino que desea iniciar contrato: ");
			result[4] = Integer.parseInt(keyboard());
			MenuProperty.showsAllProperties(prop);
			System.out.println("Ingrese el ID del inmueble que se desea alquilar: ");
			result[5] = Integer.parseInt(keyboard());
		}catch(InputMismatchException e) {
			System.out.println("Error");
			System.out.println("Usted a colocado una letra");
			System.out.println("¡Debe colocar un numero!");
		}

		return result;
	}
	public void showsAllContract(ArrayList<Contract> con) {
		con.forEach(System.out::println);
	}
	
}
