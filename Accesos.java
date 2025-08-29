import java.util.*;

public class Accesos {
  private final Hashtable<String,Integer> t=new Hashtable<>();
  public void inc(String user){ t.merge(user,1,Integer::sum); }
  public List<Map.Entry<String,Integer>> top3(){
    var l=new ArrayList<>(t.entrySet()); l.sort((a,b)->b.getValue()-a.getValue()); return l.subList(0,Math.min(3,l.size()));
  }
  public static void main(String[] a){
    var acc=new Accesos(); acc.inc("ana"); acc.inc("ana"); acc.inc("luis");
    System.out.println(acc.top3());
  }
}
// Nota: Hashtable es sincronizada (métodos synchronized). HashMap no es thread-safe.
