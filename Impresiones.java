import java.time.*; import java.util.*;

class Trabajo{final String id; final int tam; final LocalDateTime ts;
  Trabajo(String id,int tam,LocalDateTime ts){this.id=id;this.tam=tam;this.ts=ts;}
  @Override public String toString(){return id+"("+tam+")";}
}

public class Impresiones {
  private final PriorityQueue<Trabajo> pq=new PriorityQueue<>(
    Comparator.comparingInt((Trabajo t)->t.tam).thenComparing(t->t.ts)
  );
  public void enviar(Trabajo j){ pq.add(j); }
  public Trabajo atender(){ return pq.poll(); }
  public static void main(String[] a){
    var c=new Impresiones();
    c.enviar(new Trabajo("A",50, LocalDateTime.now().minusMinutes(3)));
    c.enviar(new Trabajo("B",10, LocalDateTime.now().minusMinutes(1)));
    c.enviar(new Trabajo("C",10, LocalDateTime.now().minusMinutes(5)));
    System.out.println(c.atender()); // C
  }
}
