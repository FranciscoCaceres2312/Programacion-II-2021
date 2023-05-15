package views;

import java.util.ArrayList;
import java.util.Scanner;

import model.Contract;
import model.Property;
import model.Receipt;

public class MenuReceipt {
	public static String keyboard() {
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
	}
	public String[] selectProperty(ArrayList<Property> prop, ArrayList<Contract> con) {
		String[] result = new String[3];
		MenuProperty.showsAllProperties(prop);
		System.out.println(" Ingrese el Inmueble del que desea generar recibo");
		result[0] = keyboard();
		CICLO1: 
			for(int i = 0; i < prop.size(); i++) {
				if(i+1 == Integer.parseInt(result[0])) {
				    result[0] = prop.get(i).getId();
				    break CICLO1;
				}
			}
		System.out.println(" Ingrese el valor del IVA:");
		result[1] = keyboard();
		
		System.out.println(" Ingrese el Contrato");
		MenuContract.showsAllContract(con);
		result[3] = keyboard();
		CICLO2: 
			for(int i = 0; i < con.size(); i++) {
				if(i+1 == Integer.parseInt(result[3])) {
				    result[3] = con.get(i).getId_Contract();
				    break CICLO2;
				}
			}
		return result;
	}
	
	public static void showsAllReceipt(ArrayList<Receipt> receip) {
	    receip.forEach(System.out::println);
	}

}
