package actividad_1;

import java.util.Scanner;

public class EnterosComprendidos {

	public static void main(String[] args) {
		
		Scanner scaner = new Scanner(System.in);
		
		int num1;  // primer número ingresado por el usuario
		int num2; // Segundo número ingresado por el usuario
		
		System.out.println(" Digite el primer número: ");
		num1 = scaner.nextInt();
		System.out.println(" Digite el segundo número: ");
		num2 = scaner.nextInt();
		
		System.out.println(" Los números comprendidos entre " + num1 +" y " + num2 + " son: ");
		
		for (int i = num1 + 1; i < num2; i++) {
			
			System.out.println(i);
		}

	}
}
