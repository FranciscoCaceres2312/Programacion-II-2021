package actividad_1;

import java.util.Scanner;

public class UsuarioEnzo {

	public static void main(String[] args) {
		
		Scanner escaner = new Scanner(System.in);
		
		String contraseña = "1234";
		String nombre = "Enzo";
		int concorre = 0;
		int nomcorre = 0;
		
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
		
		System.out.println(" Bienbenido "+nombre);
		
		}
	}

}
