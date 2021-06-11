package semana1;

import java.util.Scanner;

public class Ejercicio_1 {

	public static void main(String[] args) {
		
		Scanner scaner = new Scanner(System.in);
		int longi = 4;
		int i;
		String vec [] = new String [longi]; 
        for(i = 0; i < vec.length; i++) {
        	System.out.println(" Ingrese una "+ (i+1) + " oración: ");
        	vec [i] = scaner.nextLine();
        }
        for(String it : vec) {
            System.out.println(it);
        }
	}

}
