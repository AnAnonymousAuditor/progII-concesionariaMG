package AutoMG;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Gabi
 */
public class Administrativo extends Empleado{
    private static final double VALOR_HORA = 1200.0;
    private int horasExtras;

    public Administrativo(){
    }

    public Administrativo(int horasExtras, String nombre, String apellido, int dni, String mail, String codigoEmpleado, double sueldoBasico) {
        super(nombre, apellido, dni, mail, codigoEmpleado, sueldoBasico);
        this.horasExtras = horasExtras;
    }

    //GETTERS SETTERS
    public double getHorasExtras() {
        return horasExtras;
    }
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    // METODOS
    @Override
    public double calcularSueldo() {
        return sueldoBasico + (horasExtras*VALOR_HORA);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Horas extra: " + horasExtras);
    }

    public void cargarAuto(ArrayList<Auto> autosStock, Scanner num, Scanner str) {
        System.out.println("1) Familiar");
        System.out.println("2) Utilitario");
        System.out.println("3) Deportivo");
        System.out.println("<enter> otro");
        System.out.print("Tipo de auto a ingresar: ");
        int opt = num.nextInt();
        Auto nuevoAuto = switch (opt) {
            case 1 -> new AutoFamiliar();
            case 2 -> new AutoUtilitario();
            case 3 -> new AutoDeportivo();
            default -> new Auto();
        };
        System.out.println("Ingrese datos del auto:");
        nuevoAuto.cargarDatos(num, str);
        autosStock.add(nuevoAuto);
        System.out.println("Auto cargado al stock.");
    }
}
