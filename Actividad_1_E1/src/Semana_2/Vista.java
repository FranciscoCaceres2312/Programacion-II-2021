package actividad2;

import java.util.Scanner;

public class Vista {

	public static void mostrarPersona(Vista p1) {
		
		System.out.println(" Persona: "+p1);
		return;
		
	}
	
	public static Persona entregarPersona() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" Ingrese nombre: ");
		String nombre = sc.next();
		System.out.print(" Ingrese apellido: ");
		String apellido = sc.next();
		Persona pe = new Persona(apellido, nombre);
		
		return pe;
	}

	
}
