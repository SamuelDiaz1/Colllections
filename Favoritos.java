
import java.util.LinkedHashSet;
import java.util.*;

class Curso { final String id; Curso(String id){this.id=id;}
  @Override public boolean equals(Object o){return o instanceof Curso c && c.id.equals(id);}
  @Override public int hashCode(){return id.hashCode();}
  @Override public String toString(){return id;}
}

public class Favoritos {
  private final LinkedHashSet<Curso> set=new LinkedHashSet<>();
  public void marcar(Curso c){ set.add(c); }
  public void desmarcar(Curso c){ set.remove(c); }
  public List<Curso> lista(){ return new ArrayList<>(set); }
  public static void main(String[] a){
    var f=new Favoritos(); var A=new Curso("A"); var B=new Curso("B"); var C=new Curso("C");
    f.marcar(A); f.marcar(B); f.marcar(C); f.desmarcar(B); f.marcar(B);
    System.out.println(f.lista()); // [A, C, B]
  }
}
