package actividad_1;

import java.util.Scanner;

public class Adicion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
        int cantidad; // Cantidad de numeros que se van a sumar.
        float acumulador = 0; // Acumula la suma de los números que se van sumando
        float num;  // Número que ingresa el usuario.
        Scanner scaner = new Scanner(System.in);
        
        System.out.println(" -----Esta aplicación suma los números que se ingresan.-----");
        System.out.print( "¿Cuántos numeros desea sumar?");
        cantidad = scaner.nextInt();
        
        for (int i = 0 ; i < cantidad ; i++) {
        	System.out.print(" Ingrese el número que desea sumar: ");
        	num = scaner.nextFloat();
        	acumulador = acumulador + num;
        }
        
        System.out.println(" El resultado de la suma es: " + acumulador);
	}

}
