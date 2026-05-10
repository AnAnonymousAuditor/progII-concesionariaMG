package AutoMG;

import java.util.ArrayList;

/**
 * @author Gabi
 */
public class Administrativo extends Empleado{
    private double horasExtras;
    
    public Administrativo(){
    }

    public Administrativo(double horasExtras, String nombre, String apellido, int dni, String mail, String codigoEmpleado, double sueldoBasico) {
        super(nombre, apellido, dni, mail, codigoEmpleado, sueldoBasico);
        this.horasExtras = horasExtras;
    }

    //GETTERS SETTERS
    public double getHorasExtras() {
        return horasExtras;
    }
    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }
    
    // METODOS
    @Override
    public double calcularSueldo() {
        return SUELDO_MINIMO + (horasExtras*VALOR_HORA);
    }
    
    public void cargarAuto(ArrayList<Auto> autosStock, Auto nuevoAuto) {
    autosStock.add(nuevoAuto);
    System.out.println("Auto cargado al stock.");
    }
}