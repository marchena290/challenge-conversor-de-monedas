package servicios;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ServicioConversion {
    public void obtenerTasasCambio() {
        ConversorApi api = new ConversorApi();
        Gson gson = new Gson();
        try {
            // LLamar a la API y obtener la respuesta
            HttpResponse<String> response = api.consultarDivisa();

            // obtener el body en formato JSON (String)
            String json = response.body();

            //Parsear el JSON a JsonObject
            JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

            // Obtener el objeto con las tasas de cambio
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Crear un Map para almacenar las monedas filtradas
            Map<String, Double> monedasFiltradas = new HashMap<>();

            // Arreglo con codigos de las monedas
            String [] monedas = {"ARS", "COP", "USD", "BRL"};

            // Iterar sobre las monedas y extraer sus valores
            for (String moneda: monedas) {
                double valor = conversionRates.get(moneda).getAsDouble();
                monedasFiltradas.put(moneda, valor);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar a la API: ");
            e.printStackTrace();
        }
    }
}
