package main.tasks.commonTasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VerifyDebtType {
    private static List<String> debtsWithOutYear = Arrays.asList("IMT", "MOP (IMT)", "MIDF (IMT)", "RE");
    private static Map<String, String> vehicleDebtType = Map.of("IP","PROPIEDAD",
                                                         "IMT", "TRANSFERENCIA",
                                                         "MOP (IP)", "OMISION DE PAGO IPVA",
                                                         "MOP (IMT)", "OMISION DE PAGO IMT",
                                                         "MOR", "REGISTRO",
                                                         "MIDF (IMT)", "FORMALES IMT",
                                                         "MIDF (IP)", "FORMALES IPVA",
                                                         "RE", "RECIBO");
    private static Map<String, String> inmuebleDebtType = Map.of("IP","PROPIEDAD",
                                                                 "IMT", "TRANSFERENCIA",
                                                                 "MOP (IP)", "OMISION PAGO",
                                                                 "MOP (IMT)", "OMISION PAGO",
                                                                 "MOR", "REGISTRO",
                                                                 "MIDF (IMT)", "INCUMPLIMIENTO",
                                                                 "MIDF (IP)", "INCUMPLIMIENTO");
    private static Map<String, String> actividadEconomicaDebtType = Map.of("RE", "RECIBO",
                                                                           "PF", "PATENTE",
                                                                           "MIDF (PF)", "INCUMPLIMIENTO",
                                                                           "MOP (PF)", "OMISION");
    private static Map<String, String> tasasDebtType = Map.of("TA (CE)", "TASA",
                                                              "TA (ME)", "MERCADOS",
                                                              "TA (AR)", "ALQUILER ARBITRIO",
                                                              "TA (PU)", "PATENTE",
                                                              "MIDF (TOI)", "MIDF",
                                                              "OP", "",
                                                              "OM", "",
                                                              "TS", "");

    private static Map<String, Map<String, String>> debtTypes = Map.of("Vehículos", vehicleDebtType,
                                                                       "Inmuebles", inmuebleDebtType,
                                                                       "Actividades económicas", actividadEconomicaDebtType,
                                                                       "Tasas y Otros Ingresos", tasasDebtType);
    public static boolean isNecessaryVerifyYear(String debtType){
        return !debtsWithOutYear.contains(debtType);
    }
    public static boolean to(String rubro, String debtType, String debtDetail){
        return debtDetail.contains(debtTypes.get(rubro).get(debtType));
    }

}
