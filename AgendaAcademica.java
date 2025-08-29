import java.time.*; import java.util.*;

class Actividad{final String titulo; Actividad(String t){titulo=t;} @Override public String toString(){return titulo;}}

public class AgendaAcademica {
  private final TreeMap<LocalDate,List<Actividad>> m=new TreeMap<>();
  public void agregar(LocalDate d, Actividad a){ m.computeIfAbsent(d,k->new ArrayList<>()).add(a); }
  public Map.Entry<LocalDate,List<Actividad>> proxima(LocalDate hoy){ return m.ceilingEntry(hoy); }
  public NavigableMap<LocalDate,List<Actividad>> reporte(LocalDate ini, LocalDate fin){ return m.subMap(ini,true,fin,true); }
  public static void main(String[] a){
    var ag=new AgendaAcademica(); var hoy=LocalDate.now();
    ag.agregar(hoy.plusDays(1), new Actividad("Parcial")); System.out.println(ag.proxima(hoy));
  }
}
