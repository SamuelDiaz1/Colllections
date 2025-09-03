import java.util.Comparator;

public class Tienda implements Comparator<Producto> {
    private Carrito<Producto> carrito =new Carrito<>();
    public Tienda(){
        
    }
    private Carrito<Producto> compare(Producto p1, Producto p2) {
        return (p1.getPrecio() > p2.getPrecio()) ? p1 : p2;
    }
    private Producto obtenerProductoMasCaro() {
        //usa el comparador para encontrar el producto mas caro en el carrito
        Producto masCaro = null;
        for (Producto p : carrito) {      
            if (masCaro == null || compare(p, masCaro) == p) {
                masCaro = p;
            }
        }     
        return masCaro;
        
    }
}

