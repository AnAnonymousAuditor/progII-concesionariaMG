package AutoMG;

import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class AutoFamiliar extends Auto {
    private int cantidadAsientos;
    private int cantidadPuertas;

    public AutoFamiliar() {
    }

    public AutoFamiliar(int cantidadAsientos, int cantidadPuertas, String marca, String modelo, String color,
            Motor motor, double precio) {
        super(marca, modelo, color, motor, precio);
        this.cantidadAsientos = cantidadAsientos;
        this.cantidadPuertas = cantidadPuertas;
    }

    public void rebatirAsientos() {
        System.out.println("Asientos rebatidos");
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ncantidadAsientos=" + cantidadAsientos +
                "\ncantidadPuertas=" + cantidadPuertas;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println(getCantidadPuertas() + " Puertas, " + getCantidadAsientos() + " Asientos");
    }

    @Override
    public void cargarDatos(Scanner num, Scanner str) {
        super.cargarDatos(num, str);
        System.out.print("Cantidad de asientos: ");
        setCantidadAsientos(num.nextInt());
        System.out.print("Cantidad de puertas: ");
        setCantidadPuertas(num.nextInt());
    }
}
