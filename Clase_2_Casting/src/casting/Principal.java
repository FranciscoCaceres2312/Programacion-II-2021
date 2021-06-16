package casting;

public class Principal {

	public static void main(String[] args) {

        Grado ob1 = new Grado("Paca","inicial","Amarillo",21);
      

        Escuela ob2 =(Escuela) ob1;
        System.out.println(ob1);
        System.out.println("------------------------------------------------------------------");
        System.out.println(ob2);
        Escuela obEscuela = new Escuela("Paca","Inicial");
        Grado obCas =(Grado) obEscuela;
	}

}
