package views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Contract;
import model.Occupant;
import model.Property;

public class MenuContract {
	
	public static String keyboard() {
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
	}

	public String[] AddContract(ArrayList<Occupant> ocu, ArrayList<Property> prop) {
		String[] result = new String[6];
		try {
			System.out.println("Ingrese el año de inicio de contrato:");
			result[0] = keyboard();
			System.out.println("Ingrese el mes de inicio de contrato:");
			result[1] = keyboard();
			System.out.println("Ingrese el dia de inicio de contrato:");
			result[2] = keyboard();
			System.out.println("Ingrese los meses de contrato");
			result[3] = keyboard();
			//MenuOccupant.showsAllOccupants(ocu);
			System.out.println("Ingrese el inquilino que desea iniciar contrato: ");
			for(int i = 0; i < ocu.size(); i++) {
				System.out.println(i+1);
				System.out.println(ocu.get(i).getName());
				System.out.println(ocu.get(i).getDNI());
			}
			
			result[4] = keyboard();
			CICLO1:
			for(int i = 0; i < ocu.size(); i++) {
				if(i+1 == Integer.parseInt(result[4])) {
					result[4] = ocu.get(i).getId();
					break CICLO1;
				}
			}
			//MenuProperty.showsAllProperties(prop);
			System.out.println("Ingrese el inmueble que se desea alquilar: ");
			for(int i = 0; i < prop.size(); i++) {
				System.out.println(i+1);
				System.out.println(prop.get(i).getDirection());
				System.out.println(prop.get(i).getCadastralNumber());
			}
			result[5] = keyboard();
			CICLO2:
			for(int i = 0; i < prop.size(); i++) {
				if(i+1 == Integer.parseInt(result[5])) {
					result[5] = prop.get(i).getId();
					break CICLO2;
				}
			}
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
