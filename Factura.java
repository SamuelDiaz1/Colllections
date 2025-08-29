import java.util.*;

class Detalle{final String cod,nom; int cant; final double precio;
  Detalle(String c,String n,double p){cod=c;nom=n;precio=p;cant=1;}
}

public class Factura {
  private final LinkedHashMap<String,Detalle> map=new LinkedHashMap<>();
  public void escanear(String cod,String nom,double precio){
    map.merge(cod,new Detalle(cod,nom,precio),(d,neo)->{d.cant++; return d;});
  }
  public void imprimir(){
    double sub=0;
    for(var d:map.values()){ double imp=d.cant*d.precio; sub+=imp; System.out.println(d.nom+" x"+d.cant+" = "+imp); }
    double iva=sub*0.19, tot=sub+iva;
    System.out.println("Subtotal: "+sub+"\nIVA 19%: "+iva+"\nTotal: "+tot);
  }
  public static void main(String[] a){
    var f=new Factura(); f.escanear("A","Manzana",1.0); f.escanear("A","Manzana",1.0); f.imprimir();
  }
}
