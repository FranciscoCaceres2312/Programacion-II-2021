package casting;

public class Escuela {

	private String nombre;
	private String nivel;
	
	
	public Escuela(String nombre, String nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getNom() {
		return nombre;
	}
	public String getNivel() {
		return nivel;
	}
	public String toString() {
		return "Nombre: " + nombre + "\n" + "Nivel: "+nivel;
	}
	
}
