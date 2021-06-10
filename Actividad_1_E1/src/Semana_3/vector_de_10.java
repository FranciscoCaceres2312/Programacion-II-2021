package Semana_3;



public class vector_de_10 {

	public static void main(String[] args) {
		int numeros[] = new int [10]; 
		int i = 0;
		int c = 0;
		int sinmultiplos [] = new int[10];
		int sinrepetidos [] = new int[10];
		int aux [] = new int[10];
		for(i = 0; i < 10;i++) {
			
			numeros[i] = (int)(Math.random()*99+0);
			   if( numeros[i] % 7 != 0 ) { 	
		    	    c = c + 1; 
		    	    sinmultiplos[c] = numeros[i];
		        }
		}
		
		for(i= 1; i<(c+1);i++) {
			for(int j=(i+1);j<(c+1);j++) {
				if(sinmultiplos[i] > sinmultiplos[j]){
					int auxi = sinmultiplos[i];
					sinmultiplos[i] = sinmultiplos[j];
					sinmultiplos[j] = auxi;
				}
			}
		}
		int z = 0;
		int k = 0;
		for(i = 0; i < c; i++) {
			int cont = 0;
			int num = sinmultiplos[i+1];
			aux [k] = num;
			k++;
			for(int j=0;j<c;j++) {
				if(aux[j] == num) {
					cont++;
				}
			}
			if(cont == 1) {
				sinrepetidos[z] = num;
				z++;
			}
		}
		System.out.println(" Los números ordenados de menor a mayor, sin multiplos de 7 y no repetidos: ");
		for( i = 0; i < z; i++) {
			
	        System.out.print( sinrepetidos[i]+", ");
			
		}

	}

}
