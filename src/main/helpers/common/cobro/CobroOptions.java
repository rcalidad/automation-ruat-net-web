package main.helpers.common.cobro;

import java.util.Map;

public class CobroOptions {
    public static Map<String, String> menu = Map.of("LOTEO", "Loteo",
                                                    "REIMPRESI�N LOTES", "Loteo",
                                                    "PAGOS", "Pagos",
                                                    "PAGO GESTI�N VIGENTE", "Pagos",
                                                    "PAGOS CUOTAS", "Pagos",
                                                    "REIMPRESI�N PAGOS", "Pagos",
                                                    "REIMPRESI�N PAGOS CUOTAS", "Pagos");

    public static Map<String, Map<String, String>> operations = Map.of("Veh�culos", Map.of("Pagos", "pagarVehiculo",
                                                                                               "Loteo", "loteoVehiculo"),
                                                                       "Inmuebles", Map.of("Pagos", "pagarInmueble",
                                                                                               "Loteo" , "loteoInmueble"),
                                                                       "Actividades econ�micas", Map.of("Pagos", "pagarActividadEconomica",
                                                                                                            "Loteo", "loteoActividadEconomica"),
                                                                       "Tasas y Otros Ingresos", Map.of("Pagos", "pagarTasasOtrosIngresos",
                                                                                                            "Loteo", "loteoTasasOtrosIngresos"));
}
