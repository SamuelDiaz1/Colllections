package soporteTecnico;
public enum Severidad {
    CRITICA(4), ALTA(3), MEDIA(2), BAJA(1);

    private int nivel;

    Severidad(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
