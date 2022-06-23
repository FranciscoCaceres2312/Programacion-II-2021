package casting;

public class Escuela {

	protected String nombre;
	protected String nivel;
	
	
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
	@Override
	public boolean equals(Object obj) {
		Escuela comparacionEscuela = (Escuela) obj;
		return this.getNom(). equals (comparacionEscuela.getNom());
	}
}
