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
	public int[] selectProperty(ArrayList<Property> prop) {
		int[] result = new int[2];
		MenuProperty.showsAllProperties(prop);
		System.out.println(" Ingrese el id del Inmueble del que desea generar recibo");
		result[0] = Integer.parseInt(keyboard());
		System.out.println(" Ingrese el valor del IVA:");
		result[1] = Integer.parseInt(keyboard());
		return result;
	}
	
	public static void showsAllReceipt(ArrayList<Receipt> receip) {
	    receip.forEach(System.out::println);
	}

}
