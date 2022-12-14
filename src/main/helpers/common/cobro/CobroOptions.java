package main.helpers.common.cobro;

import java.util.Map;

public class CobroOptions {
    public static Map<String, String> menu = Map.of("LOTEO", "Loteo",
                                                    "REIMPRESIÓN LOTES", "Loteo",
                                                    "PAGOS", "Pagos",
                                                    "PAGO GESTIÓN VIGENTE", "Pagos",
                                                    "PAGOS CUOTAS", "Pagos",
                                                    "REIMPRESIÓN PAGOS", "Pagos",
                                                    "REIMPRESIÓN PAGOS CUOTAS", "Pagos");

    public static Map<String, Map<String, String>> operations = Map.of("Vehículos", Map.of("Pagos", "pagarVehiculo",
                                                                                               "Loteo", "loteoVehiculo"),
                                                                       "Inmuebles", Map.of("Pagos", "pagarInmueble",
                                                                                               "Loteo" , "loteoInmueble"),
                                                                       "Actividades económicas", Map.of("Pagos", "pagarActividadEconomica",
                                                                                                            "Loteo", "loteoActividadEconomica"),
                                                                       "Tasas y Otros Ingresos", Map.of("Pagos", "pagarTasasOtrosIngresos",
                                                                                                            "Loteo", "loteoTasasOtrosIngresos"));
}
