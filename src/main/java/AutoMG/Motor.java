package AutoMG;

/**
 *
 * @author manuel
 */
public class Motor {
    private int kilometrosRecorridos;
    private double cilindrada;
    private int caballosFuerza;

    public boolean requiereCambioAceite() {
        return getKilometrosRecorridos() > 100000;
    }

    public Motor(int km, int caballos, double cilindrada) {
        this.caballosFuerza = caballos;
        this.cilindrada = cilindrada;
        this.kilometrosRecorridos = km;
    }

    public Motor() {
        this.caballosFuerza = 0;
        this.cilindrada = 0;
        this.kilometrosRecorridos = 0;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public int getCaballosFuerza() {
        return caballosFuerza;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setCaballosFuerza(int caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    @Override
    public String toString() {
        return "Motor=" +
            "\n\tkilometrosRecorridos=" + kilometrosRecorridos +
            "\n\tcilindrada=" + cilindrada +
            "\n\tcaballosFuerza=" + caballosFuerza;
    }
}
