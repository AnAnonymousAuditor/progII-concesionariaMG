package AutoMG;


/**
 *
 * @author manuel
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Auto {

    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private Motor motor;

    void avanzar(int km) {

        this.motor.setKilometrosRecorridos(this.motor.getKilometrosRecorridos() + km);

        if (motor.requiereCambioAceite()) {
            JOptionPane.showMessageDialog(
                null,
                "Requiere cambio de aceite",
                getMarca() + " " + getModelo(),
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public Auto() {
    }

    public Auto(String marca, String modelo, String color, Motor motor, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.getClass() +
                "\nmarca=" + marca +
                "\nmodelo=" + modelo +
                "\ncolor=" + color +
                "\nmotor=" + motor +
                "\nprecio=" + precio;
    }

    public void mostrarInfo() {
        Motor m = getMotor();
        System.out.println(getMarca() + " " + getModelo() + " (" + getColor() + ")");
        System.out.println(String.format("%,d", m.getKilometrosRecorridos()) + " km");
        System.out.println("$" + String.format("%,.2f", getPrecio()));
        System.out.println("Motor " + m.getCilindrada() + "L, " + m.getCaballosFuerza() + " HP");
    }

    public void cargarDatos(Scanner sc) {
        Motor m = new Motor();

        System.out.print("Marca del auto: ");
        setMarca(sc.nextLine());
        System.out.print("Modelo del auto: ");
        setModelo(sc.nextLine());
        System.out.print("Color del auto: ");
        setColor(sc.nextLine());
        System.out.print("Precio del auto: ");
        setPrecio(sc.nextDouble());
        System.out.print("Cilindrada del motor: ");
        m.setCilindrada(sc.nextDouble());
        System.out.print("Potencia del motor: ");
        m.setCaballosFuerza(sc.nextInt());
        System.out.print("Km recorridos del auto:");
        m.setKilometrosRecorridos(sc.nextInt());
    }
}
