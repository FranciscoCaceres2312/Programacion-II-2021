package actividad_1;

import java.util.Scanner;

public class Advertencia {
    
    public static void main( String[] args) {
    	
    	 Scanner escaner = new Scanner(System.in);
		  
	        int num1;   // Variable que almacena el valor del primer n�mero ingresado
			int num2;  // Variable que almacena el valor del segundo n�mero ingresado
			int num3;  // Almacena el valor del numero extra
			int num4;  // Variable bandera
		    
			System.out.println(" Este programa lista todos los n�meros que se encuentran entre los que usted ingrese, a excepcion de los multiplos del n�mero que se indique.");
			
			System.out.print(" Ingrese el primer n�mero: ");
			num1 = escaner.nextInt();
			System.out.print(" Ingrese el segundo n�mero: ");
			num2 = escaner.nextInt();
			System.out.println(" Digite el n�mero con el cual se operar�: ");
			num3 = escaner.nextInt();
		
			
			if (num1 > num2) {
			   
				num4 = num1 - num2;				

			    if (num3 < num4) {
			        System.out.println(" Los n�meros comprendidos entre " +num2+ " y " +num1+ " son: ");
// Primer bucle 	
			    for (int i = (1 + num2); i < num1; i++) {
			    	
			    	if (i % num3 != 0) {
			    		
			    		 System.out.println(i);
			    	}
			    
			    }
			    }else {
			    	
			    	System.out.println( num3 + " no es un n�mero permitido. ");
			    }
			}
			    else if (num2 > num1) {
			    	
			    	num4 = num2 - num1;
			    	
			    	if (num3 < num4) {
			    		
			    		System.out.println(" Los n�meros comprendidos entre " +num1+ " y " +num2+ " son: ");
// Segundo bucle 			    		
				    for (int i = (1 + num1); i < num2; i++) {
				    	if (i % num3 != 0) {
				    	System.out.println(i);
				    	}
				    }
			    	}else {
			    	
			    	System.out.println(num3 + " no es un n�mero permitido. ");
			    	}
			    }
    	
    }
}
