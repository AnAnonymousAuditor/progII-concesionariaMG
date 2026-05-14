package AutoMG;

import java.util.ArrayList;

/**
 * @author Gabi
 */
public class Vendedor extends Empleado{
    private static final double VALOR_COMISION = 5000.0;
    private int cantVentas;

    public Vendedor(){
    }

    public Vendedor(int cantVentas, String nombre, String apellido, int dni, String mail, String codigoEmpleado, double sueldoBasico) {
        super(nombre, apellido, dni, mail, codigoEmpleado, sueldoBasico);
        this.cantVentas = cantVentas;
    }

    //GETTERS SETTERS
    public int getCantVentas() {
        return cantVentas;
    }
    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }

    // METODOS
    @Override
    public double calcularSueldo() {
        return sueldoBasico + cantVentas*VALOR_COMISION;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Cantidad de ventas: " + cantVentas);
    }

    public void venderAuto(ArrayList<Auto> autosStock, ArrayList<Auto> autosVendidos, Auto autoAVender) {
        if (autosStock.contains(autoAVender)) {
            autosStock.remove(autoAVender);
            autosVendidos.add(autoAVender);
            this.cantVentas++;
            System.out.println("Auto vendido con éxito.");
        } else {
            System.out.println("El auto no se encuentra en el stock.");
        }
    }

}
