package AutoMG;

/**
 *
 * @author manuel
 */
public class AutoFamiliar extends Auto {
    private int cantidadAsientos;
    private int cantidadPuertas;

    public AutoFamiliar() {
    }

    public AutoFamiliar(int cantidadAsientos, int cantidadPuertas, String marca, String modelo, String color, Motor motor, double precio) {
        super(marca, modelo, color, motor, precio);
        this.cantidadAsientos = cantidadAsientos;
        this.cantidadPuertas = cantidadPuertas;
    }

}
