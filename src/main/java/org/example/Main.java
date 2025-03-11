package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> listaCarros = new ArrayList<>();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Crear Auto");
            System.out.println("2. Mostrar Detalles de Autos");
            System.out.println("3. Actualizar Kilometraje");
            System.out.println("4. Verificar si el Auto es Antiguo");
            System.out.println("5. Verificar si el Auto necesita Mantenimiento");
            System.out.println("6. Calcular Consumo de Combustible");
            System.out.println("7. Calcular Combustible Restante");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el año: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese el kilometraje: ");
                    double kilometraje = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese el estado: ");
                    String estado = scanner.nextLine();
                    System.out.print("Ingrese la placa: ");
                    String placa = scanner.nextLine();

                    listaCarros.add(new Carro(marca, modelo, anio, kilometraje, estado, placa));
                    System.out.println("Auto creado exitosamente.");
                }
                case 2 -> {
                    if (listaCarros.isEmpty()) {
                        System.out.println("No hay autos en la lista.");
                    } else {
                        for (Carro carro : listaCarros) {
                            carro.mostrarDetalles();
                            System.out.println();
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese la placa del auto a actualizar: ");
                    String placa = scanner.nextLine();
                    Carro autoEncontrado = buscarAutoPorPlaca(listaCarros, placa);
                    if (autoEncontrado != null) {
                        System.out.print("Ingrese el nuevo kilometraje: ");
                        double nuevoKilometraje = scanner.nextDouble();
                        autoEncontrado.actualizarKilometraje(nuevoKilometraje);
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print ("Ingrese la placa del auto a verificar: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarAutoPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        if (carroEncontrado.esAntiguo()) {
                            System.out.println("El auto es antiguo.");
                        } else {
                            System.out.println("El auto no es antiguo.");
                        }
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese la placa del auto a verificar: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarAutoPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        if (carroEncontrado.necesitaMantenimiento()) {
                            System.out.println("El auto necesita mantenimiento.");
                        } else {
                            System.out.println("El auto no necesita mantenimiento.");
                        }
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 6 -> {
                    System.out.print("Ingrese la placa del auto: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarAutoPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        System.out.print("Ingrese la distancia recorrida: ");
                        double distancia = scanner.nextDouble();
                        System.out.print("Ingrese el consumo por km: ");
                        double consumoPorKm = scanner.nextDouble();
                        double consumo = carroEncontrado.calcularConsumoCombustible(distancia, consumoPorKm);
                        System.out.println("Consumo de combustible: " + consumo + " litros.");
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 7 -> {

                    System.out.print("Ingrese la placa del auto: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarAutoPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        System.out.print("Ingrese la capacidad del tanque: ");
                        double capacidadTanque = scanner.nextDouble();
                        System.out.print("Ingrese el consumo de combustible: ");
                        double consumo = scanner.nextDouble();
                        double combustibleRestante = carroEncontrado.combustibleRestante(capacidadTanque, consumo);
                        System.out.println("Combustible restante: " + combustibleRestante + " litros.");
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 8 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static Carro buscarAutoPorPlaca(ArrayList<Carro> listaAutos, String placa) {
        for (Carro auto : listaAutos) {
            if (auto.getPlaca().equalsIgnoreCase(placa)) {
                return auto;
            }
        }
        return null;
    }
}