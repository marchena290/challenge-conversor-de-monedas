package principal;

import servicios.ServicioConversion;

public class Principal {
    public static void main(String[] args) {
        ServicioConversion servicio = new ServicioConversion();
        servicio.obtenerTasasCambio();

        MenuConversor menu = new MenuConversor(servicio);
        menu.mostrarMenu();
    }
}
