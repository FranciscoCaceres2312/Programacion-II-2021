package actividad_1;

import java.util.Scanner;

public class CambioContraseña {

	public static void main(String[] args) {
		
Scanner escaner = new Scanner(System.in);
		
		String contraseña = "1234";
		String nombre = "Enzo";
		int concorre = 0;
		int nomcorre = 0;
		int eleccion;
		String nuevacontraseña, comprobador;
		
		do {
			
		System.out.print(" Ingrese su nombre: ");
		String usuario = escaner.nextLine();
		System.out.print(" Ingrese su contraseña: ");
		String password = escaner.nextLine();
		
		if (usuario.equals(nombre)) {
			
			System.out.println(" ¡¡Nombre correcto!!");
			nomcorre = 4;
			
		}else {
			
			nomcorre = nomcorre + 1;
			System.out.println(" El nombre no coincide. ");
			
		}
		if (password.equals(contraseña)) {
			
			System.out.println(" ¡¡Contraseña correcta!! ");
			
			concorre = 4;
			
		}else {
			
			System.out.println(" La contraseña no coincide. ");
			concorre = concorre + 1;
		}

		}while(concorre < 4 || nomcorre < 4);
		
		if (concorre == 4 && nomcorre == 4) {
		
		System.out.print(" Bienbenido "+nombre);
		System.out.println();
		
		}
		int x = 0;
		do {
		System.out.println( " 1-   Cambiar la contraseña. ");
		System.out.println(" 2-   Conservar contraseña. ");
		eleccion = escaner.nextInt();
		
		if ( eleccion == 1) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print(" Ingrese la nueva contraseña: ");
			nuevacontraseña = sc.nextLine();
			System.out.print(" Repita la contraseña para comprobar. ");
		    comprobador = sc.nextLine();
		    
		    if (comprobador.equals(nuevacontraseña)) {
		    	
		    	System.out.println(" La nueva contraseña se asignó correctamente. ");
		    	x = 3;
		    	
		    }else {
		    	
		    	System.out.println(" Las contraseñas no coinciden. ");
		    	x = x + 1;
		    	
		    }
			
		}else if( eleccion == 2) {
			
			System.out.println(" Se conservará la misma contraseña.");
			x = 3;
			
		}
		
		} while(x < 3);	
		
		System.out.println(" ¡¡Gracias por operar!! ");
	}

}
