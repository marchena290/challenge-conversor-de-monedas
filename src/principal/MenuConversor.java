package principal;

import servicios.ServicioConversion;

import java.util.Scanner;

public class MenuConversor {
    private final ServicioConversion servicio;

    public MenuConversor(ServicioConversion servicio) {
        this.servicio = servicio;
    }

    // Solicita y valida una cantidad positiva desde la entrada del usuario
    private double pedirCantidad(Scanner scanner, String mensaje) {
        while(true) {

            System.out.println(mensaje);

            // Reemplaza la coma por punto para aceptar ambos formatos decimales
            String input = scanner.nextLine().replace(',', '.');

            try {
                double cantidad = Double.parseDouble(input);
                if (cantidad < 0 ) {
                    System.out.println("No se permiten cantidades negativas. Intente de nuevo.");
                    continue;
                }
                return cantidad;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, por favor ingrese un número válido.");
            }
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while(!salir) {
            System.out.println("=== Conversor de Monedas ===");
            System.out.println("1) Dolar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("============================");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1 :
                    double cantidad1 = pedirCantidad(scanner, "Ingrese la cantidad que desea convertir (USD a ARS): ");
                    double resultadoA = servicio.convertirDeUsdAMoneda("ARS", cantidad1);
                    System.out.printf("El valor de %.2f [USD] corresponde al valor final de: %.2f [ARS]%n ", cantidad1, resultadoA);
                    break;
                case 2 :
                    double cantidad2 = pedirCantidad(scanner, "Ingrese la cantidad que desea convertir (ARS a USD): ");
                    double resultado2 = servicio.convertirDeMonedaAUsd("ARS", cantidad2);
                    System.out.printf("El valor de %.2f [ARS] corresponde al valor final de: %.2f [USD]%n ", cantidad2, resultado2);
                    break;
                case 3 :
                    double cantidad3 = pedirCantidad(scanner,"Ingrese la cantidad que desea convertir (USD a BRL): ");
                    double resultado3 = servicio.convertirDeUsdAMoneda("BRL", cantidad3);
                    System.out.printf("El valor de %.2f [USD] corresponde al valor final de: %.2f [BRL]%n ", cantidad3, resultado3);
                    break;
                case 4 :
                    double cantidad4 = pedirCantidad(scanner,"Ingrese la cantidad que desea convertir (BRL a USD): ");
                    double resultado4 = servicio.convertirDeMonedaAUsd("BRL", cantidad4);
                    System.out.printf("El valor de %.2f [BRL] corresponde al valor final de: %.2f [USD]%n ", cantidad4, resultado4);
                    break;
                case 5 :
                    double cantidad5 = pedirCantidad(scanner, "Ingrese la cantidad que desea convertir (USD a COP): ");
                    double resultado5 = servicio.convertirDeUsdAMoneda("COP", cantidad5);
                    System.out.printf("El valor de %.2f [USD] corresponde al valor final de: %.2f [COP]%n ", cantidad5, resultado5);
                    break;
                case 6 :
                    double cantidad6 = pedirCantidad(scanner, "Ingrese la cantidad que desea convertir (COP a USD): ");
                    double resultado6 = servicio.convertirDeMonedaAUsd("COP", cantidad6);
                    System.out.printf("El valor de %.2f [COP] corresponde al valor final de: %.2f [USD]%n ", cantidad6, resultado6);
                    break;
                case 7 :
                    salir = true;
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        scanner.close();
    }
}
