import java.util.*;

class Lote{final String id; Lote(String id){this.id=id;} @Override public String toString(){return id;}}

public class Lotes {
  private final ArrayDeque<Lote> dq=new ArrayDeque<>();
  public void encolar(Lote l){ dq.addLast(l); }
  public void urgente(Lote l){ dq.addFirst(l); }
  public Lote procesar(){ return dq.pollFirst(); }
  public static void main(String[] a){
    var p=new Lotes(); p.encolar(new Lote("A")); p.encolar(new Lote("B")); p.urgente(new Lote("U"));
    System.out.println(p.procesar()); // U
  }
}
