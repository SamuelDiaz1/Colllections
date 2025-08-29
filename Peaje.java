import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class Peaje {
    private TreeMap<Integer, BigDecimal> tarifas;

    public Peaje() {
        tarifas = new TreeMap<>();
        // Definimos los tramos
        tarifas.put(0, new BigDecimal("5000"));    // 0kg en adelante
        tarifas.put(1000, new BigDecimal("8000")); // 1000kg en adelante
        tarifas.put(2000, new BigDecimal("12000"));// 2000kg en adelante
        tarifas.put(3000, new BigDecimal("18000"));// 3000kg en adelante
    }

    // Obtener la tarifa según el peso
    public BigDecimal calcularTarifa(int peso) {
        Map.Entry<Integer, BigDecimal> entry = tarifas.floorEntry(peso);
        if (entry != null) {
            return entry.getValue();
        } else {
            // Si no hay tramo menor, tomamos el más cercano hacia arriba
            return tarifas.ceilingEntry(peso).getValue();
        }
    }
}

