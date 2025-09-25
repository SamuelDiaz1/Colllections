import java.util.Comparator;

public class Tienda implements Comparator<Producto> {
    private Carrito<Producto> carrito =new Carrito<>();
    public Tienda(){
        
    }
    @Override
    public int compare(Producto p1, Producto p2) {
        return Double.compare(p1.getPrecio(), p2.getPrecio());
    }
    private Producto obtenerProductoMasCaro() {
        //usa el comparador para encontrar el producto mas caro en el carrito
        Producto masCaro = null;
        for (Producto p : carrito) {      
            if (masCaro == null || compare(p, masCaro) > 0) {
                masCaro = p;
            }
        }     
        return masCaro;
        
    }
}

