package actividad_1;

import java.util.Scanner;

public class SinMultiplosde5 {
	public static void main(String[] args) {
		
Scanner escaner = new Scanner(System.in);
		
	    int num1;   // Vraiable que almacena el valor del primer n�mero ingresado
		int num2;  // Variable que almacena el valor del segundo n�mero ingresado
		
		System.out.print(" Ingrese el primer n�mero: ");
		num1 = escaner.nextInt();
		System.out.print(" Ingrese el segundo n�mero: ");
		num2 = escaner.nextInt();
		
		if (num1 > num2) {
		    System.out.println(" Los n�meros comprendidos entre " +num2+ " y " +num1+ " son: ");
		    for (int i = (1 + num2); i < num1; i++) {
		    	
		    	if (i % 5 != 0) {
		    		
		    		 System.out.println(i);
		    	}
		    	
		    }
		}
		    else if (num2 > num1) {
		    	System.out.println(" Los n�meros comprendidos entre " +num1+ " y " +num2+ " son: ");
			    for (int i = (1 + num1); i < num2; i++) {
			    	if (i % 5 != 0) {
			    	System.out.println(i);
			    	}
			    }
		    }

	}
}
