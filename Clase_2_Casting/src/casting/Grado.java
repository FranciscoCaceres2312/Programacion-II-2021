package casting;

public class Grado extends Escuela{

	private String nom;
	private int cantAlum;
	
	public Grado(String nombre, String nivel, String nom, int cantidad) {
		super(nombre,nivel);
		this.nom = nom;
		this.cantAlum = cantidad;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setCantidad(int cantidad) {
		this.cantAlum = cantidad;
	}
	public int getCantidad() {
		return cantAlum;
	}
	public String toString(){
		return "Nombre de escuela: "+nombre+"\n"+" Nivel: "+nivel+"\n"+" Nombre de grado: "+nom+ "\n" + " Cantidad de alumnos: " +cantAlum ;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
