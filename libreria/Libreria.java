package libreria;
import java.util.ArrayList;
import java.util.Comparator;

public class Libreria implements Comparator<Libro> {
    private ArrayList<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "libreria [libros=" + libros + "]";
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    // Metodo para agregar libros sin que se repitan validando por el ISBN
    public void agregarLibro(Libro libro) {
        boolean existe = false;
        for (Libro l : libros) {
            if (libro.getIsbn().equals(l.getIsbn())) {
                existe = true;
            }
        }
        if (existe == true) {
            System.out.println("El libro ya existe");
        } else {
            libros.add(libro);
        }
    }

    @Override
    public int compare(Libro l1, Libro l2) {
        // TODO Auto-generated method stub
        return l1.getIsbn().compareTo(l2.getIsbn());
    }

    // Metodo para eliminar un libro por ISBN
    public void eliminarLibro(Libro libro) {
        boolean existe = false;
        for (Libro l : libros) {
            if (libro.getIsbn().equals(l.getIsbn())) {
                existe = true;
            }
        }
        if (existe == true) {
            System.out.println("El libro ya existe");
        } else {
            libros.remove(libro);
        }
    }
}
