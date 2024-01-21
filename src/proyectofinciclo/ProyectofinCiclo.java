/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinciclo;

import java.util.Scanner;

/**
 *
 * @author yixon
 */
public class ProyectofinCiclo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        abb abbTree = new abb();

        boolean exit = false;
        do {
            System.out.println("--------------------");
            System.out.println("   MENU PRINCIPAL   ");
            System.out.println("--------------------");
            System.out.println("1. Ingresar");
            System.out.println("2. Consultar");
            System.out.println("3. Salir");
            System.out.println("\nDigite su opción: ");

            String choiceInput = scanner.nextLine(); // Leer la línea completa

            if (choiceInput.trim().isEmpty()) {
                System.out.println("Por favor, ingrese un número entero.");
                continue; // Volver al inicio del bucle
            }

            try {
                int choice = Integer.parseInt(choiceInput);
                switch (choice) {
                    case 1:
                        ingresarDatos(abbTree);
                        break;
                    case 2:
                        menuConsultar(abbTree);
                        break;
                    case 3:
                        System.out.println("¡Gracias!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        } while (!exit);
    }

    private static void ingresarDatos(abb abbTree) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar dato (número entero): ");

        String input = scanner.nextLine(); // Leer la línea completa

        // Verificar si el input contiene solo dígitos y no está vacío
        if (input.matches("\\d+") && !input.trim().isEmpty()) {
            int dato = Integer.parseInt(input);
            abbTree.insertarabb(dato);
            System.out.println("Dato insertado en ABB.");
        } else {
            System.out.println("Entrada inválida. Ingrese un número entero válido.");
        }
    }

    private static void menuConsultar(abb abbTree) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("-------------------");
            System.out.println("   MENU CONSULTA   ");
            System.out.println("-------------------");
            System.out.println("1. Preorden");
            System.out.println("2. Postorden");
            System.out.println("3. Inorden");
            System.out.println("4. Visualizar");
            System.out.println("5. Regresar");
            System.out.println("\nDigite su opción: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("ABB");
                        System.out.println("Preorden");
                        abbTree.RecPreOrdenabb();
                        break;
                    case 2:
                        System.out.println("ABB");
                        System.out.println("Postorden");
                        abbTree.RecPosOrdenabb();
                        break;
                    case 3:
                        System.out.println("ABB");
                        System.out.println("Inorden");
                        abbTree.RecInOrdenabb();
                        break;
                    case 4:
                        System.out.println("Visualizando ABB:");
                        abbTree.graficarabb();
                        break;
                    case 5:
                        System.out.println("Regresando al menú principal.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                        break;
                }
            } else {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.next();
            }
        } while (!exit);
    }
}
