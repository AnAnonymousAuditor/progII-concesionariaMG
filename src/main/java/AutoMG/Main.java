
package AutoMG;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class Main {

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
            System.out.println();
        }

        System.out.println("-----------");

        auto1.avanzar(40000);
        autoFamiliar1.avanzar(20000);
        autoUtilitario1.avanzar(60000);
        autoDeportivo1.avanzar(5000);

        for (Auto auto : autos) {
            auto.mostrarInfo();
            System.out.println();
        }

        System.out.println("==============================");

        Scanner num = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        ArrayList<Auto> autosStock = new ArrayList<>();
        ArrayList<Auto> autosVendidos = new ArrayList<>();
        ArrayList<Administrativo> listaAdministrativos = new ArrayList<>();
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();

        //CARGAR GERENTE PARA CARGAR EMPLEADOS
        Gerente jefe = new Gerente(15000.0, "Mario", "Santos", 11222333, "mario@auto.com", "G01", 80000.0);

        // GERENTE AGREGA A LAS LISTAS DE EMPLEADO
        Administrativo admin1 = new Administrativo(20, "Pepe", "Argento", 22333444, "pepe@auto.com", "A01", 25000.0);
        Vendedor vend1 = new Vendedor(0, "Luis", "Mauri", 33444555, "luis@auto.com", "V01", 25000.0);
        jefe.cargarAdministrativo(listaAdministrativos, admin1);
        jefe.cargarVendedor(listaVendedores, vend1);

        System.out.println("------ Cargar Autos ------");
        boolean listo = false;
        while (!listo) {
            admin1.cargarAuto(autosStock, num, str);
            System.out.println("Desea agregar otro auto? (s/n)");
            listo = str.nextLine().charAt(0) == 'n';
        }

        //SIMULAR VENTA - MUESTA AUTOS Y ELIGE
        listo = false;
        while (!listo) {
            System.out.println("Seleccione el número de auto a vender:");

            int i = 1;
            for (Auto auto : autosStock) {
                System.out.println((i) + ". " + auto.getMarca() + " " + auto.getModelo());
                i++;
            }
            int opcion = num.nextInt() - 1;

            if ((opcion) >= 0 && (opcion) < autosStock.size()) {
                Auto elegido = autosStock.get((opcion));
                vend1.venderAuto(autosStock, autosVendidos, elegido);
            } else {
                System.out.println("Opción inválida.");
            }

            System.out.println("Desea vender otro auto? (s/n)");
            listo = str.nextLine().charAt(0) == 'n';
        }

        System.out.println("\n--- AUTOS STOCK ------");
        for (Auto auto : autosStock) {
            auto.mostrarInfo();
            System.out.println();
        }
        System.out.println("------------------------");

        // SIMULAR AVANCE
        int km;
        for (Auto auto : autosStock) {
            System.out.println("Ingresar nuevos km recorridos por " + auto.getMarca() + " " + auto.getModelo() + ":");
            km = num.nextInt();
            auto.avanzar(km);
        }

        System.out.println("\n--- AUTOS STOCK ------");
        for (Auto auto : autosStock) {
            auto.mostrarInfo();
        }
        System.out.println("------------------------");

        System.out.println("\n--- AUTOS VENDIDOS ---");
        for (Auto auto : autosVendidos) {
            auto.mostrarInfo();
        }
        System.out.println("------------------------");

        System.out.println("\n");
        System.out.println("==== REPORTE DETALLADO DE EMPLEADOS ====");

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
}
