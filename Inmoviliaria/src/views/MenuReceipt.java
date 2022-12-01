package views;

import java.util.ArrayList;
import java.util.Scanner;

import model.Property;
import model.Receipt;

public class MenuReceipt {
	public static String keyboard() {
		Scanner scaner = new Scanner (System.in);
		String var = scaner.nextLine();
		return var;
	}
	public String[] selectProperty(ArrayList<Property> prop) {
		String[] result = new String[2];
		MenuProperty.showsAllProperties(prop);
		System.out.println(" Ingrese el id del Inmueble del que desea generar recibo");
		result[0] = keyboard();
		System.out.println(" Ingrese el valor del IVA:");
		result[1] = keyboard();
		return result;
	}
	
	public static void showsAllReceipt(ArrayList<Receipt> receip) {
	    receip.forEach(System.out::println);
	}

}
