package libreria;
public class Libro {
    private String titulo;
    private String isbn;
    private String anio;
    private Autor autor ;
    public Libro(String titulo, String isbn, String anio, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAnio() {
        return anio;
    }
    public void setAnio(String anio) {
        this.anio = anio;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", anio=" + anio + ", autor=" + autor + "]";
    }
     
}
