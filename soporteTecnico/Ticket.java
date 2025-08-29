package soporteTecnico;

import java.time.LocalDateTime;

public class Ticket {
    private String descripcion;
    private Severidad severidad;
    private LocalDateTime fechaCreacion;

    public Ticket(String descripcion, Severidad severidad, LocalDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.fechaCreacion = fechaCreacion;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String toString() {
        return "[" + severidad + "] " + descripcion + " (" + fechaCreacion + ")";
    }
}

