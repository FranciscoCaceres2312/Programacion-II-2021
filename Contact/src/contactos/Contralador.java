package contactos;

public class Contralador {

	public static void main(String[] args) {
		
		ContactBook lc = null;
		
		do{
		
	int respuestaMenu = Vista.menu();
	
	
	if(respuestaMenu == 1) {
		lc = Vista.createContactBook(new ContactBook());
	System.out.println(lc);
	}
	else if (respuestaMenu == 2) {	
				
	ContactBook miCon = Vista.addingContactBook(lc);
	System.out.println(miCon);
		
	}
		}while(true);

	}

}
