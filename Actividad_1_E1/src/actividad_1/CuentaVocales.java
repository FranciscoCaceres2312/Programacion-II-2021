package actividad_1;

import java.util.Scanner;

public class CuentaVocales {
	
	public static void main(String[] main) {
		
		Scanner entrada = new Scanner(System.in);
		
		char letras[] = {'a', 'e','i','o','u'};
		
		int numeroVocales = 0;
		String frase, fraseenminusculas;
		
		System.out.print(" Ingrese una frase: ");
		frase = entrada.nextLine();
		fraseenminusculas = frase.toLowerCase();
		
		for (int i = 0; i < fraseenminusculas.length(); i++) {
			
			char letra = fraseenminusculas.charAt(i);
			
			if ( letra != ' ') {
			
			    for (int j = 0; j < letras.length; j++) {
				
				    if ( letra == letras[j]) {
					
					    numeroVocales ++;
					    break;
					
				    }
				
			    }
			
			}
			
		}
		
		System.out.println(" La frase contiene "+numeroVocales+ " vocales.");
		
	} 

}
