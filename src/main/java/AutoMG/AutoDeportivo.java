package AutoMG;

import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class AutoDeportivo extends Auto {
    private double tiempoAceleracion; // Tiempo en segundos de 0 a 100 km/h
    private boolean tieneTurbo;

    public AutoDeportivo() {
    }

    public AutoDeportivo(double tiempoAceleracion, boolean tieneTurbo, String marca, String modelo, String color,
            Motor motor, double precio) {
        super(marca, modelo, color, motor, precio);
        this.tiempoAceleracion = tiempoAceleracion;
        this.tieneTurbo = tieneTurbo;
    }

    public void activarModoDeportivo() {
        System.out.println("Modo deportivo activado");
    }

    public void desactivarModoDeportivo() {
        System.out.println("Modo deportivo desactivado");
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

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        if (isTieneTurbo())
            System.out.println("Con turbo");
        System.out.println(getTiempoAceleracion() + "s de 0 a 100 km/h");
    }

    @Override
    public void cargarDatos(Scanner num, Scanner str) {
        super.cargarDatos(num, str);
        System.out.print("Tiempo de Aceleración 0-100 km/h: ");
        setTiempoAceleracion(num.nextDouble());
        System.out.print("Tiene turbo (s/n): ");
        setTieneTurbo(str.nextLine().charAt(0) == 's');
    }
}
