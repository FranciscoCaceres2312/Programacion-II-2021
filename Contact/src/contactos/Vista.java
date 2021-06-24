package contactos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {

	public static int menu() {
		int option = 0;
		
		
	try {
		Scanner scaner = new Scanner (System.in);
		System.out.println(" Elija una opción: ");
		System.out.println(" 1-  Agregar Libreta de Contactos: ");
		System.out.println(" 2-  Agregar un nuevo contacto a la libreta de contacto:  ");
		option = scaner.nextInt();
				
		} catch (InputMismatchException e) {
			System.out.println("error");
			System.out.println("usted a colocado una letra");
			System.out.println("¡debe colocar un numero¡");
		}		
		return option;
	}
	
	public static ContactBook createContactBook(ContactBook conBook1) {
		Scanner teclado  = new Scanner (System.in);
		
	
		System.out.println(" Ingrese el nombre de la Libreta de Contactos: ");
		String newNomCon = teclado.nextLine();
		
		//ContactBook book1 = new ContactBook(newNomCon);
		System.out.println(" El nombre de la libreta de contactos  "+newNomCon+" se guardo correctamente. ");
		conBook1.setName(newNomCon);
		
			
		return conBook1;
	
	}
	
	public static ContactBook addingContactBook(ContactBook cont1) {
		
		ArrayList contacts = new ArrayList();	
		
		Scanner scaner1 = new Scanner (System.in);
		String name, mail, mob;
		int option = 0;
		boolean topList= false;
		
		System.out.println(" Escriba los datos de contacto para guardarlos ");
		System.out.println(" Nombre:");
			name = scaner1.nextLine();
		System.out.println("Email:");
			mail = scaner1.nextLine();
		System.out.println(" Número de telefono:");
			mob = scaner1.nextLine();
			
			try {
		System.out.println(" ¿Desea guardarlo en topList? ");
		System.out.println(" 1- SI");
		System.out.println(" 2- NO");
			option = scaner1.nextInt();	
			
			switch(option) {
			case 1:	
				topList = true;
				break;
			case 2:
				topList = false;
				break;
		}
				} catch (InputMismatchException|NullPointerException e) {
					System.out.println("¡Error!");
					System.out.println(" Usted a colocado una letra ");
					System.out.println(" ¡Debe colocar un numero!");
				}
		
		
		
		Contact contact1 = new Contact(name, mail, mob, topList);
		cont1.addContact(contact1);
		
		return cont1;
	}
}
