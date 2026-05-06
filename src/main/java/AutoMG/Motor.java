/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoMG;

/**
 *
 * @author manuel
 */
public class Motor {
    private int kilometrosRecorridos;
    private double cilindrada;
    private double caballosFuerza;

    public boolean requiereCambioAceite() {
        if (this.kilometrosRecorridos > 100000) return true;
        else return false;
    }

    public Motor(int km, double caballos, double cilindrada) {
        this.caballosFuerza = caballos;
        this.cilindrada = cilindrada;
        this.kilometrosRecorridos = km;
    }

    public Motor() {
        this.caballosFuerza = 0;
        this.cilindrada = 0;
        this.kilometrosRecorridos = 0;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public double getCaballosFuerza() {
        return caballosFuerza;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setCaballosFuerza(double caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    @Override
    public String toString() {
        return "Motor{" + "kilometrosRecorridos=" + kilometrosRecorridos + ", cilindrada=" + cilindrada + ", caballosFuerza=" + caballosFuerza + '}';
    }
}