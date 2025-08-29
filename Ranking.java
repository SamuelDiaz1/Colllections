import java.util.*;

class Deportista{final String apellido; final int puntos; Deportista(String a,int p){apellido=a;puntos=p;}
  @Override public String toString(){return apellido+":"+puntos;}
}

public class Ranking {
  private final Comparator<Deportista> cmp=Comparator.<Deportista>comparingInt(d->d.puntos).reversed()
                                                      .thenComparing(d->d.apellido);
  private final TreeSet<Deportista> set=new TreeSet<>(cmp);
  public void add(Deportista d){ set.add(d); }
  public List<Deportista> top10(){ var r=new ArrayList<Deportista>(); int k=0; for(var d:set){ if(k++==10) break; r.add(d);} return r; }
  public static void main(String[] a){
    var r=new Ranking(); r.add(new Deportista("Zapata",100)); r.add(new Deportista("Arango",100)); r.add(new Deportista("Mina",120));
    System.out.println(r.top10()); // [Mina:120, Arango:100, Zapata:100]
  }
}
