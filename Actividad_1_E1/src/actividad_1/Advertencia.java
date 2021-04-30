package actividad_1;

import java.util.Scanner;

public class Advertencia {
    
    public static void main( String[] args) {
    	
    	 Scanner escaner = new Scanner(System.in);
		  
	        int num1;   // Variable que almacena el valor del primer número ingresado
			int num2;  // Variable que almacena el valor del segundo número ingresado
			int num3;  // Almacena el valor del numero extra
			int num4;  // Variable bandera
		    
			System.out.println(" Este programa lista todos los números que se encuentran entre los que usted ingrese, a excepcion de los multiplos del número que se indique.");
			
			System.out.print(" Ingrese el primer número: ");
			num1 = escaner.nextInt();
			System.out.print(" Ingrese el segundo número: ");
			num2 = escaner.nextInt();
			System.out.println(" Digite el número con el cual se operará: ");
			num3 = escaner.nextInt();
		
			
			if (num1 > num2) {
			   
				num4 = num1 - num2;				

			    if (num3 < num4) {
			        System.out.println(" Los números comprendidos entre " +num2+ " y " +num1+ " son: ");
// Primer bucle 	
			    for (int i = (1 + num2); i < num1; i++) {
			    	
			    	if (i % num3 != 0) {
			    		
			    		 System.out.println(i);
			    	}
			    
			    }
			    }else {
			    	
			    	System.out.println( num3 + " no es un número permitido. ");
			    }
			}
			    else if (num2 > num1) {
			    	
			    	num4 = num2 - num1;
			    	
			    	if (num3 < num4) {
			    		
			    		System.out.println(" Los números comprendidos entre " +num1+ " y " +num2+ " son: ");
// Segundo bucle 			    		
				    for (int i = (1 + num1); i < num2; i++) {
				    	if (i % num3 != 0) {
				    	System.out.println(i);
				    	}
				    }
			    	}else {
			    	
			    	System.out.println(num3 + " no es un número permitido. ");
			    	}
			    }
    	
    }
}
