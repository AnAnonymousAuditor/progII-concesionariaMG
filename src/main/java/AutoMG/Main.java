
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
        // ---------------- COMIENZO LABORATORIO 3 ----------------
        ArrayList<Auto> autos = new ArrayList<>();

        Motor motor1 = new Motor(50000, 132, 1.8);
        Auto auto1 = new Auto("Toyota", "Corolla", "Blanco", motor1, 3000000);
        autos.add(auto1);

        Motor motor2 = new Motor(120000, 102, 1.6);
        AutoFamiliar autoFamiliar1 = new AutoFamiliar(5, 5, "vw", "suran", "gris", motor2, 2000000);
        autos.add(autoFamiliar1);

        Motor motor3 = new Motor(205000, 164, 2.5);
        AutoUtilitario autoUtilitario1 = new AutoUtilitario(1333, true, "ford", "ranger", "azul", motor3, 1500000);
        autos.add(autoUtilitario1);

        Motor motor4 = new Motor(0, 492, 5.0);
        AutoDeportivo autoDeportivo1 = new AutoDeportivo(4.3, false, "ford", "mustang", "negro", motor4, 20000000);
        autos.add(autoDeportivo1);

        for (Auto auto : autos) {
            auto.mostrarInfo();
        }
        // ---------------- FIN LABORATORIO 3 ---------------------

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
        simularavance(autosStock, sc);

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
        mostrardatos(autosStock);
        System.out.println("\n--- AUTOS VENDIDOS ---");
        mostrardatos(autosVendidos);

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

    public static void simularavance(ArrayList<Auto> autosStock, Scanner sc){

        int km;

        for (int i = 0; i < CANTAUTOS; i++){

            System.out.println("Ingresar nuevos km recorridos por auto " + (i+1) + ":");
            km = sc.nextInt();
            autosStock.get(i).avanzar(km);
            sc.nextLine();
        }
    }
    public static void mostrardatos(ArrayList<Auto> autosStock){

        for (int i = 0; i < autosStock.size(); i++){

            System.out.println("--- Reporte del Auto " + (i+1) + " ---");
            System.out.println("modelo del auto:" + autosStock.get(i).getModelo());
            System.out.println("Color del auto:" + autosStock.get(i).getColor());
            System.out.println("Marca del auto:" + autosStock.get(i).getMarca());
            System.out.println("Precio del auto:" + autosStock.get(i).getPrecio());
            System.out.println("Km recorriodos del auto:" + autosStock.get(i).getMotor().getKilometrosRecorridos());
            System.out.println("Cilindraje del auto: " + autosStock.get(i).getMotor().getCilindrada());
            System.out.println("Caballos del auto: " + autosStock.get(i).getMotor().getCaballosFuerza());
        }
    }
}
