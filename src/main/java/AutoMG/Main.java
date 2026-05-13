
package AutoMG;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class Main {

    static final int CANTAUTOS = 3;
    public static void main(String[] args) {

        ArrayList<Auto> autos = new ArrayList<>();

        Motor motor1 = new Motor(70000, 132, 1.8);
        Auto auto1 = new Auto("Toyota", "Corolla", "Blanco", motor1, 3000000);
        autos.add(auto1);

        Motor motor2 = new Motor(120000, 102, 1.6);
        AutoFamiliar autoFamiliar1 = new AutoFamiliar(5, 5, "VW", "Suran", "Gris", motor2, 2000000);
        autos.add(autoFamiliar1);

        Motor motor3 = new Motor(205000, 164, 2.5);
        AutoUtilitario autoUtilitario1 = new AutoUtilitario(1333, true, "Ford", "Ranger", "Azul", motor3, 1500000);
        autos.add(autoUtilitario1);

        Motor motor4 = new Motor(0, 492, 5.0);
        AutoDeportivo autoDeportivo1 = new AutoDeportivo(4.3, false, "Ford", "Mustang", "Negro", motor4, 20000000);
        autos.add(autoDeportivo1);

        for (Auto auto : autos) {
            auto.mostrarInfo();
        }

        auto1.avanzar(40000);
        autoFamiliar1.avanzar(20000);
        autoUtilitario1.avanzar(60000);
        autoDeportivo1.avanzar(5000);

        for (Auto auto : autos) {
            auto.mostrarInfo();
        }


        Scanner sc = new Scanner(System.in);
        ArrayList<Auto> autosStock = new ArrayList<>();
        ArrayList<Auto> autosVendidos = new ArrayList<>();
        ArrayList<Administrativo> listaAdministrativos = new ArrayList<>();
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();

        //CARGAR GERENTE PARA CARGAR EMPLEADOS
        Gerente jefe = new Gerente(15000.0, "Mario", "Santos", 11222333, "mario@auto.com", "G01", 80000.0);

        // GERENTE AGREGA A LAS LISTAS DE EMPLEADO
        Administrativo admin1 = new Administrativo(5.0, "Pepe", "Argento", 22333444, "pepe@auto.com", "A01", 25000.0);
        Vendedor vend1 = new Vendedor(0, "Luis", "Mauri", 33444555, "luis@auto.com", "V01", 25000.0);
        jefe.cargarAdministrativo(listaAdministrativos, admin1);
        jefe.cargarVendedor(listaVendedores, vend1);

        // cargar 3 autos distintos con la ayuda de administrativo
        cargarautos(autosStock, sc, admin1);

        // SIMULAR AVANCE
        simularAvance(autosStock, sc);

        //SIMULAR VENTA - MUESTA AUTOS Y ELIGE
        System.out.println("Seleccione el número de auto a vender:");

        for (int i = 0; i < autosStock.size(); i++) {
            System.out.println((i + 1) + ". " + autosStock.get(i).getModelo());
        }
        int opcion = sc.nextInt();

        if ((opcion -1) >= 0 && (opcion -1) < autosStock.size()) {
            Auto elegido = autosStock.get((opcion -1));
            vend1.venderAuto(autosStock, autosVendidos, elegido);
        } else {
            System.out.println("Opción inválida.");
        }

        System.out.println("\n--- AUTOS STOCK ---");
        mostrarDatos(autosStock);
        System.out.println("\n--- AUTOS VENDIDOS ---");
        mostrarDatos(autosVendidos);

        System.out.println("REPORTE DETALLADO DE EMPLEADOS");

        System.out.println("GERENCIA");
        jefe.mostrarInformacion();

        System.out.println("\nADMINISTRATIVOS");
        for (Administrativo a : listaAdministrativos) {
            a.mostrarInformacion();
        }
        System.out.println("\nVENDEDORES");
        for (Vendedor v : listaVendedores) {
            v.mostrarInformacion();
        }

    }

    //ingreso de datos (de motor solo di la opcion de cargar km para hacerla corta)
    public static void cargarautos(ArrayList<Auto> autosStock, Scanner sc, Administrativo admin){

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

            Auto nuevoAuto = new Auto(marca, modelo, color, mimotor, precio);
            admin.cargarAuto(autosStock, nuevoAuto);
        }
    }

    public static void simularAvance(ArrayList<Auto> autosStock, Scanner sc){

        int km;

        for (Auto auto : autosStock) {
            System.out.println("Ingresar nuevos km recorridos por " + auto.getMarca() + auto.getModelo() + ":");
            km = sc.nextInt();
            auto.avanzar(km);
            sc.nextLine();
        }
    }

    public static void mostrarDatos(ArrayList<Auto> autosStock){

        for (Auto auto : autosStock) {
            System.out.println("--- Reporte del Auto " + autosStock.indexOf(auto) + " ---");
            auto.mostrarInfo();
            System.out.println();
        }
    }
}
