import java.util.*;

class Producto{final String codigo,nombre; int stock; double precio;
  Producto(String c,String n,int s,double p){codigo=c;nombre=n;stock=s;precio=p;}
  @Override public String toString(){return nombre+" ["+codigo+"] x"+stock+" $"+precio;}
}

public class Inventario {
  private final Map<String,Producto> m=new HashMap<>();
  public void agregar(Producto p){ m.put(p.codigo,p); }
  public void actualizarStock(String c,int s){ if(m.containsKey(c)) m.get(c).stock=s; }
  public Double precioPorCodigo(String c){ return m.containsKey(c)? m.get(c).precio : null; }
  public List<Producto> faltantes(){
    var r=new ArrayList<Producto>(); for(var p:m.values()) if(p.stock==0) r.add(p); return r;
  }
  public static void main(String[] a){
    var inv=new Inventario(); inv.agregar(new Producto("P1","Clavo",0,100));
    System.out.println(inv.faltantes());
  }
}
