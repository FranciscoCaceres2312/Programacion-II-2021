package semana1;
import java.util.Scanner;
public class Ejercicio_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String user [] = new String[4]; 
        user [0] = "daiana";
        user [1] = "facundo";
        user [2] = "osvaldo";
        user [3] = "melina";
        String pass [] = new String [4];
        pass [0] = "1234";
        pass [1] = "4321";
        pass [2] = "1122";
        pass [3] = "3344";
        int condi = 1;
        do {
        System.out.println(" ----Ingrese su nombre de Usuario----");
        String nombre = teclado.nextLine();
        String name = nombre.toLowerCase();
        System.out.println(" ----Ingrese su contraseña----");
        String passw = teclado.nextLine();
        int i;
        for(i = 0; i < 4; i++) {
        	if(name.equals(user[i]) && passw.equals(pass[i])) {
        		System.out.println(" Bienbenid@ "+ user[i]);
        		condi = 2;
            }
        	}
            if(condi != 2) {
            	System.out.println(" No concidio ");
            }
        }while(condi == 1);
	}

}
