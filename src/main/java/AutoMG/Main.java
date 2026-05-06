/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package AutoMG;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class Main {

    static final int CANTAUTOS = 3;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Auto> autos = new ArrayList<>();


        cargarautos(autos, sc);

        simularavance(autos, sc);

        mostrardatos(autos);

        Motor mimotor = new Motor(50, 110, 300);

        Auto auto1 = new Auto("vw", "fox", "blanco", mimotor, 1000000);
        AutoFamiliar autofamiliar1 = new AutoFamiliar(5, 5, "vw", "suran", "negro", mimotor, 1500000);
        AutoUtilitario autoutilitario1 = new AutoUtilitario(3000, true, "ford", "ranger", "azul", mimotor, 3000000);
        AutoDeportivo autodeportivo1 = new AutoDeportivo(4.2, true, "ford", "mustang", "rojo", mimotor, 5000000);

        System.out.println(auto1);
        System.out.println(autofamiliar1);
        System.out.println(autoutilitario1);
        System.out.println(autodeportivo1);

    }

    //ingreso de datos (de motor solo di la opcion de cargar km para hacerla corta)
    public static void cargarautos(ArrayList<Auto> autos, Scanner sc){

        String modelo;
        String marca;
        String color;
        double precio;
        int km;

        for (int i = 0; i < CANTAUTOS; i++){

            Motor mimotor = new Motor(0, 110, 300);

            System.out.println("--- Datos del Auto " + (i+1) + " ---");
            System.out.println("Ingrese modelo del auto:");
            modelo = sc.nextLine();
            System.out.println("Color del auto:");
            color = sc.nextLine();
            System.out.println("Marca del auto:");
            marca = sc.nextLine();
            System.out.println("Precio del auto:");
            precio = sc.nextDouble();
            System.out.println("Km recorriodos del auto:");
            km = sc.nextInt();
            mimotor.setKilometrosRecorridos(km);
            sc.nextLine();//los nextline son para limpiar el buffer

            autos.add(new Auto(marca, modelo, color, mimotor, precio));
        }
    }

    public static void simularavance(ArrayList<Auto> autos, Scanner sc){

        int km;

        for (int i = 0; i < CANTAUTOS; i++){

            System.out.println("Ingresar nuevos km recorridos por auto " + (i+1) + ":");
            km = sc.nextInt();
            autos.get(i).avanzar(km);
            sc.nextLine();
        }
    }
    public static void mostrardatos(ArrayList<Auto> autos){

        for (int i = 0; i < CANTAUTOS; i++){

            System.out.println("--- Reporte del Auto " + (i+1) + " ---");
            System.out.println("modelo del auto:" + autos.get(i).getModelo());
            System.out.println("Color del auto:" + autos.get(i).getColor());
            System.out.println("Marca del auto:" + autos.get(i).getMarca());
            System.out.println("Precio del auto:" + autos.get(i).getPrecio());
            System.out.println("Km recorriodos del auto:" + autos.get(i).getMotor().getKilometrosRecorridos());
            System.out.println("Cilindraje del auto: " + autos.get(i).getMotor().getCilindrada());
            System.out.println("Caballos del auto: " + autos.get(i).getMotor().getCaballosFuerza());
        }
    }

}
