package AutoMG;

/**
 * @author Gabi
 */
public abstract class Empleado {

    protected String nombre;
    protected String apellido;
    protected int dni;
    protected String mail;
    protected String codigoEmpleado;
    protected double sueldoBasico;

    public Empleado(){}

    public Empleado(String nombre, String apellido, int dni, String mail, String codigoEmpleado, double sueldoBasico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.codigoEmpleado = codigoEmpleado;
        this.sueldoBasico = sueldoBasico;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    public double getSueldoBasico() {
        return sueldoBasico;
    }
    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public abstract double calcularSueldo();

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("E-mail: " + mail);
        System.out.println("Código: " + codigoEmpleado);
        System.out.println("Sueldo a cobrar: $" + String.format("%,.2f", calcularSueldo()));
    }
}
