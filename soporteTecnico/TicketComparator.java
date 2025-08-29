package soporteTecnico;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        // Comparar por severidad (descendente)
        int compSeveridad = Integer.compare(
            t2.getSeveridad().getNivel(),
            t1.getSeveridad().getNivel()
        );
//
        if (compSeveridad != 0) {
            return compSeveridad;
        }

        // Si tienen misma severidad, comparar por fecha (ascendente)
        return t1.getFechaCreacion().compareTo(t2.getFechaCreacion());
    }
}

