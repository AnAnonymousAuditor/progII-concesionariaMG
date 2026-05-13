package AutoMG;

/**
 *
 * @author manuel
 */
public class AutoUtilitario extends Auto {
    private int capacidadCarga; // kg
    private boolean es4x4;

    public AutoUtilitario() {}

    public AutoUtilitario(int capacidadCarga, boolean es4x4, String marca, String modelo, String color, Motor motor, double precio) {
        super(marca, modelo, color, motor, precio);
        this.capacidadCarga = capacidadCarga;
        this.es4x4 = es4x4;
    }

    public void abrirCajaCarga() {
        System.out.println("Caja de carga abierta");
    }

    public void cerrarCajaCarga() {
        System.out.println("Caja de carga cerrada");
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isEs4x4() {
        return es4x4;
    }

    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\ncapacidadCarga=" + capacidadCarga +
            "\n es4x4=" + es4x4;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        if (es4x4) System.out.println("4x4");
        System.out.println("Hasta " + getCapacidadCarga() + "kg de carga");
    }
}
