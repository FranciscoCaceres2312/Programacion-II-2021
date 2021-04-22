
public class Bicicleta {
    
    private String nroDeSerie ;
    private String modelo;
    private int anio;
    private float precio;

    public Bicicleta(String nroDeSerie, String modelo, int anio) {
        this.nroDeSerie = nroDeSerie;
        this.modelo = modelo;
        this.anio = anio;
    }
    
    public String getNroDeSerie(){
        return this.nroDeSerie;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
