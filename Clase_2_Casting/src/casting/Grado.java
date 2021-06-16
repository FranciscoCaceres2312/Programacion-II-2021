package casting;

public class Grado extends Escuela{

	private String nom;
	private int cantAlum;
	
	public Grado(String nombre, String nivel, String nom, int cantidad) {
		super(nombre,nivel);
		this.nom = nom;
		this.cantAlum = cantidad;
	}
	
	public void setNombre(String nombre) {
		this.nom = nombre;
	}
	public String getNombre() {
		return nom;
	}
	public void setCantidad(int cantidad) {
		this.cantAlum = cantidad;
	}
	public int getCantidad() {
		return cantAlum;
	}
	public String toString(){
		return "Nombre: "+nom+ "\n" + "Cantidad de alumnos: " +cantAlum ;
	}
}
