package actividad_1;

import java.util.Scanner;

public class CambioContrase�a {

	public static void main(String[] args) {
		
Scanner escaner = new Scanner(System.in);
		
		String contrase�a = "1234";
		String nombre = "Enzo";
		int concorre = 0;
		int nomcorre = 0;
		int eleccion;
		String nuevacontrase�a, comprobador;
		
		do {
			
		System.out.print(" Ingrese su nombre: ");
		String usuario = escaner.nextLine();
		System.out.print(" Ingrese su contrase�a: ");
		String password = escaner.nextLine();
		
		if (usuario.equals(nombre)) {
			
			System.out.println(" ��Nombre correcto!!");
			nomcorre = 4;
			
		}else {
			
			nomcorre = nomcorre + 1;
			System.out.println(" El nombre no coincide. ");
			
		}
		if (password.equals(contrase�a)) {
			
			System.out.println(" ��Contrase�a correcta!! ");
			
			concorre = 4;
			
		}else {
			
			System.out.println(" La contrase�a no coincide. ");
			concorre = concorre + 1;
		}

		}while(concorre < 4 || nomcorre < 4);
		
		if (concorre == 4 && nomcorre == 4) {
		
		System.out.print(" Bienbenido "+nombre);
		System.out.println();
		
		}
		int x = 0;
		do {
		System.out.println( " 1-   Cambiar la contrase�a. ");
		System.out.println(" 2-   Conservar contrase�a. ");
		eleccion = escaner.nextInt();
		
		if ( eleccion == 1) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print(" Ingrese la nueva contrase�a: ");
			nuevacontrase�a = sc.nextLine();
			System.out.print(" Repita la contrase�a para comprobar. ");
		    comprobador = sc.nextLine();
		    
		    if (comprobador.equals(nuevacontrase�a)) {
		    	
		    	System.out.println(" La nueva contrase�a se asign� correctamente. ");
		    	x = 3;
		    	
		    }else {
		    	
		    	System.out.println(" Las contrase�as no coinciden. ");
		    	x = x + 1;
		    	
		    }
			
		}else if( eleccion == 2) {
			
			System.out.println(" Se conservar� la misma contrase�a.");
			x = 3;
			
		}
		
		} while(x < 3);	
		
		System.out.println(" ��Gracias por operar!! ");
	}

}
