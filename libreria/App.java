package libreria;
//import java.util.Collection;
import java.util.Collections;

public class App {

    public static void main(String[] args)   {
        //proobar el codigo de libreria aqui    
       Autor autor1=new Autor("");
        Autor autor2=new Autor("Isabel Allende");
        Autor autor3=new Autor("Mario Vargas Llosa");
        Libro libro1=new Libro("Cien Años de Soledad","A12345","1967",autor1);
        Libro libro2=new Libro("La Casa de los Espíritus","A67890","1982",autor2);
        Libro libro3=new Libro("La Ciudad y los Perros","A54321","1963",autor3);
        Libreria miLibreria=new Libreria();
        miLibreria.getLibros().add(libro1);         
        miLibreria.getLibros().add(libro2);
        miLibreria.getLibros().add(libro3);
        System.out.println(miLibreria);
        //probar el metodo compare aqui
        Collections.sort(miLibreria.getLibros(),miLibreria);
        System.out.println(miLibreria);
    }
}