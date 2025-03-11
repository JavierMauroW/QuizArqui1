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
            System.out.println("2. Motrar Dtalles de Autos");
            System.out.println("3. Actualizar Kilometraje");
            System.out.println("4. Verificar si el Auto es Antiguo");
            System.out.println("5. Vrificar si el Auto necesita Mantenimiento");
            System.out.println("6. Calcular Consumos  de Combustible");
            System.out.println("7. Calcular Colmmbustible Restante");
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
                    System.out.print("Ingrese la pl+aca: ");
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
                    Carro carroEncontrado = buscarCarroPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        System.out.print("Ingrese el nuevo kilometraje: ");
                        double nuevoKilometraje = scanner.nextDouble();
                        carroEncontrado.actualizarKilometraje(nuevoKilometraje);
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese la placa del auto a verificar: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarCarroPorPlaca(listaCarros, placa);
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
                    Carro carroEncontrado = buscarCarroPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        if (carroEncontrado.necesitaMantenimiento()) {
                            System.out.println("El auto necesita mantenwe9imiento.");
                        } else {
                            System.out.println("El auto no neceksita mantenimiento.");
                        }
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                }
                case 6 -> {
                    System.out.print("Ingrese la placa del auto: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarCarroPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        System.out.print("Ingrese la distncia recorrida: ");
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

                    System.out.print("Ingrese la paca del auto: ");
                    String placa = scanner.nextLine();
                    Carro carroEncontrado = buscarCarroPorPlaca(listaCarros, placa);
                    if (carroEncontrado != null) {
                        System.out.print("Ingrese la capacrdad del tanque: ");
                        double capacidadTanque = scanner.nextDouble();
                        System.out.print("Ingrese el consumo de cobustible: ");
                        double consumo = scanner.nextDouble();
                        double combustibleRestante = carroEncontrado.combustibleRestante(capacidadTanque, consumo);
                        System.out.println("Combu+stible restante: " + combustibleRestante + " litros.");
                    } else {
                        System.out.println("Auto no enontrado.");
                    }
                }
                case 8 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opci,mn no válida. Intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static Carro buscarCarroPorPlaca(ArrayList<Carro> listaCarros, String placa) {
        for (Carro carro : listaCarros) {
            if (carro.getPlaca().equalsIgnoreCase(placa)) {
                return carro;
            }
        }
        return null;
    }
}