/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AutoMG;

/**
 *
 * @author manuel
 */
import javax.swing.*;

public class Auto {

    private String marca;
    private String modelo;
    private String color;

    private Motor motor;

    private double precio;

    void avanzar(int km){

        this.motor.setKilometrosRecorridos(this.motor.getKilometrosRecorridos()+km);

        if (motor.requiereCambioAceite()) JOptionPane.showMessageDialog(null, "requiere cambio de aceite");
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
}
