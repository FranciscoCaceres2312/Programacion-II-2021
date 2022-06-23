
package casting;

public class Principal {

	public static void main(String[] args) {

        Grado ob1 = new Grado("Paca","inicial","Amarillo",21);
      

        Escuela ob2 =(Escuela) ob1;
        System.out.println(ob1);
        System.out.println("------------------------------------------------------------------");
        System.out.println(ob2);
        System.out.println("----------------------------------------------------------------");
        
        Escuela obEscuela = new Escuela("Alicia","Secundario");
        System.out.println(obEscuela); 
        Grado obCas =(Grado) obEscuela;
        System.out.println(obCas); 
        
        System.out.println("-------------------");
        Escuela obEscuela_1 = new Escuela("Godoy","Primario");
        Escuela obEscuela_2 = new Escuela("Godoy","Primario");
        System.out.println(obEscuela_1.equals(obEscuela_2));
        
        System.out.println("------------------------------");
        Grado obgrado1 = new Grado("Godoy","Secundaria","Azul",22);
        Grado obgrado2 = new Grado("Godoy","Secundaria","Azul",22); 
        System.out.println(obgrado1.equals(obgrado2));
	}

}
