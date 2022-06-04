package actividad2;

public class Persona {
	
	private String apellido;
	private String nombre;
	
	public Persona(String apellido, String nombre) {
		
		this.apellido = apellido;
		this.nombre = nombre;
		
	}
	

	public void setApellido(String apellido) {
		
		this.apellido = apellido;
		
	}
	
	public String getApellido() {
		
		return apellido;
	}
	
    public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String getnombre() {
		
		return nombre;
	}

}
