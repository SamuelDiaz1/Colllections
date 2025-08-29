import java.util.*;

public class LRU<K,V> extends LinkedHashMap<K,V>{ 
  private final int cap;
  public LRU(int cap){ super(16,0.75f,true); this.cap=cap; }
  @Override protected boolean removeEldestEntry(Map.Entry<K,V> e){ return size()>cap; }
  public static void main(String[] a){
    var c=new LRU<Integer,String>(2); c.put(1,"a"); c.put(2,"b"); c.get(1); c.put(3,"c");
    System.out.println(c.keySet()); // [1, 3]
  }
}
