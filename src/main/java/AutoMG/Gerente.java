package AutoMG;

import java.util.ArrayList;

/**
 * @author Gabi
 */
public class Gerente extends Empleado{
    private double bonoAdicional;

    public Gerente() {
    }

    public Gerente(double bonoAdicional, String nombre, String apellido, int dni, String mail, String codigoEmpleado, double sueldoBasico) {
        super(nombre, apellido, dni, mail, codigoEmpleado, sueldoBasico);
        this.bonoAdicional = bonoAdicional;
    }
    public double getBonoAdicional() {
        return bonoAdicional;
    }
    public void setBonoAdicional(double bonoAdicional) {
        this.bonoAdicional = bonoAdicional;
    }

    @Override
    public double calcularSueldo() {
        return getSueldoBasico() + bonoAdicional;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Bono adicional: $" + String.format("%,.2f", bonoAdicional));
    }

    public void cargarAdministrativo(ArrayList<Administrativo> listaAdministrativos, Administrativo a) {
        listaAdministrativos.add(a);
    }
    public void cargarVendedor(ArrayList<Vendedor> listaVendedores, Vendedor v) {
        listaVendedores.add(v);
    }
}
