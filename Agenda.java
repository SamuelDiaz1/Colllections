
import java.time.*; import java.util.*;

class Reunion implements Comparable<Reunion>{
  final LocalDateTime fecha; final String asunto;
  Reunion(LocalDateTime f,String a){fecha=f;asunto=a;}
  public int compareTo(Reunion r){ int c=fecha.compareTo(r.fecha); return c!=0?c:asunto.compareTo(r.asunto); }
  @Override public String toString(){return fecha+" - "+asunto;}
}

public class Agenda {
  private final NavigableSet<Reunion> ts=new TreeSet<>();
  public void agregar(Reunion r){ ts.add(r); }
  public Reunion primera(){ return ts.first(); }
  public Reunion ultima(){ return ts.last(); }
  public SortedSet<Reunion> rango(LocalDateTime ini, LocalDateTime fin){
    return ts.subSet(new Reunion(ini,""), true, new Reunion(fin,"~"), true);
  }
  public static void main(String[] a){
    var ag=new Agenda();
    ag.agregar(new Reunion(LocalDateTime.now().plusDays(1),"Daily"));
    ag.agregar(new Reunion(LocalDateTime.now().plusDays(10),"Cierre"));
    System.out.println(ag.primera());
  }
}
