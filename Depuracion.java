import java.util.*;

public class Depuracion {
  public static void filtrar(Set<String> correos, Set<String> vetados){
    for(Iterator<String> it=correos.iterator(); it.hasNext(); ){
      String mail=it.next(); String dom=mail.substring(mail.indexOf('@')+1);
      if(vetados.contains(dom)) it.remove();
    }
  }
  public static void main(String[] a){
    var set=new HashSet<>(List.of("a@x.com","b@y.com","c@x.com"));
    filtrar(set, Set.of("x.com")); System.out.println(set); // [b@y.com]
  }
}
