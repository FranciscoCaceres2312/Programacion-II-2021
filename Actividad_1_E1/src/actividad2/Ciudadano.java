package actividad2;

public class Ciudadano extends Persona{
	
	private String provincia;
	private long dni;
	
	public Ciudadano(String provincia, long dni, String nombre, String apellido) {
		
		super( apellido, nombre);
		this.dni = dni;
		this.provincia = provincia;
		
	}
	
	public void setDni (long dni) {
		
		this.dni = dni;
		
	}
	
	public void setProvincia (String provincia) {
		
		this.provincia = provincia;
		
	}
	
	public String getProvincia() {
		
		return provincia;
		
	}
	
	public long getDni () {
		
		return dni;
		
	}

}
