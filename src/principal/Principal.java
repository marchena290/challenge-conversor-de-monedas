package principal;

import servicios.ServicioConversion;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServicioConversion servicio = new ServicioConversion();
        servicio.obtenerTasasCambio();
        servicio.obtenerMonedaCrc();
        System.out.println("El valor de la moneda de costa rica es de: " + servicio.obtenerMonedaCrc());
    }
}
