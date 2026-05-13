package AutoMG;

/**
 *
 * @author manuel
 */
public class AutoDeportivo extends Auto {
    // Tiempo en segundos de 0 a 100 km/h
    private double tiempoAceleracion;
    private boolean tieneTurbo;

    public AutoDeportivo() {}

    public AutoDeportivo(double tiempoAceleracion, boolean tieneTurbo, String marca, String modelo, String color, Motor motor, double precio) {
        super(marca, modelo, color, motor, precio);
        this.tiempoAceleracion = tiempoAceleracion;
        this.tieneTurbo = tieneTurbo;
    }

    public double getTiempoAceleracion() {
        return tiempoAceleracion;
    }

    public void setTiempoAceleracion(double tiempoAceleracion) {
        this.tiempoAceleracion = tiempoAceleracion;
    }

    public boolean isTieneTurbo() {
        return tieneTurbo;
    }

    public void setTieneTurbo(boolean tieneTurbo) {
        this.tieneTurbo = tieneTurbo;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\ntiempoAceleracion=" + tiempoAceleracion +
            "\ntieneTurbo=" + tieneTurbo;
    }
}
