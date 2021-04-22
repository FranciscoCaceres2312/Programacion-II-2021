
import java.util.ArrayList;


public class Bicicleteria {
    
    private ArrayList<Bicicleta> bicicletas;
    private float ganancias;
    private Integer cantidadDeVentas;

    public Bicicleteria() {
        this.bicicletas = new ArrayList<Bicicleta>();
        this.cantidadDeVentas = 0;
        this.ganancias = 0;
    }
    
    public void venderBicicleta (Bicicleta bicicleta){
        bicicletas .remove(bicicleta);
        cantidadDeVentas ++;
        ganancias = ganancias + bicicleta.getPrecio();
    }
    
    public void addBicicleta(Bicicleta nuevaBici){
    
        this.bicicletas.add(nuevaBici);
    }
    
    // Ejercicio 2 del examen final
    
    public Bicicleta buscarBicicleta (String nroDeSerie){
    
        for(int i = 0 ; i < this.bicicletas.size();i++){
            Bicicleta bici = this.bicicletas.get(i);
            
            if ( bici.getNroDeSerie() == nroDeSerie){
                return bici;
            }
        }
        
        return null;
    }
}