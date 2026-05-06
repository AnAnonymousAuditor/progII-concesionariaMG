package AutoMG;

/**
 *
 * @author manuel
 */
public class AutoUtilitario extends Auto {
    private int capacidadCarga;
    private boolean es4x4;

    public AutoUtilitario() {
    }

    public AutoUtilitario(int capacidadCarga, boolean es4x4, String marca, String modelo, String color, Motor motor, double precio) {
        super(marca, modelo, color, motor, precio);
        this.capacidadCarga = capacidadCarga;
        this.es4x4 = es4x4;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\ncapacidadCarga=" + capacidadCarga +
            "\n es4x4=" + es4x4;
    }

}
